package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.Section;
import pl.edu.pjwstk.jaz.user.product.add.parameter.AddParameterRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Named
//@RequestScoped
@ManagedBean
@ViewScoped
public class AddProductController implements Serializable {
    private static final long serialVersionUID = 1;
    @Inject
    private ProductService productService;

    @Inject
    private ParamRetriever paramRetriever;

    private AddProductRequest addProductRequest;

    public AddProductRequest getAddRequest() {
        if (addProductRequest == null) {
            addProductRequest = new AddProductRequest();
        }
        return addProductRequest;
    }

    public List<Category> getCategoryListBySectionId() {
        if (getAddRequest().getSectionId() != null) {
            Long sectionId = getAddRequest().getSectionId();
            return productService.findCategoryBySectionId(sectionId);
        }
        Long sectionMinId = productService.getSectionMinId();
        return productService.findCategoryBySectionId(sectionMinId); //TODO


    }

    public Long getOwnerId() {
        Long ownerId = paramRetriever.getLongUserId("id");
        addProductRequest.setOwnerId(ownerId);
        return addProductRequest.getOwnerId();
    }

    public List<Product> getProductListByOwnerId() {
        Long ownerId = getOwnerId();
        return productService.getProductListByOwnerId(ownerId);
    }

    public String save() {
        var category = productService.findCategoryById(addProductRequest.getCategoryId()).orElseThrow();
        Long version = 1L;
        productService.save(new Product(addProductRequest.getTitle(), addProductRequest.getDescription(),
                addProductRequest.getPrice(), getOwnerId(), category, version));

        return "/user/parameter/addParameter.xhtml?faces-redirect=true";
    }
}
