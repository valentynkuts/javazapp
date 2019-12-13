package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.CategoryService;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;
import pl.edu.pjwstk.jaz.user.product.add.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditProductController {
    @Inject
    private EditProductService editProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private EditProductRequest editProductRequest;
    private EditPhotoRequest editPhotoRequest;

    public EditProductRequest getEditProductRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditProductRequest();
           //System.out.println("getEditProductRequest:"+editProductRequest.getId()+"   "+editProductRequest.getTitle()+"  "+editProductRequest.getDescription());
        }
        return editProductRequest;
    }

    public EditPhotoRequest getEditPhotoRequest() {
        if (editPhotoRequest == null) {
            editPhotoRequest = new EditPhotoRequest();
        }
        return editPhotoRequest;
    }

    private EditProductRequest createEditProductRequest() {
        if (paramRetriever.contains("productId")) {
            var productId = paramRetriever.getLong("productId");
            //System.out.println("productId: "+productId);

            var product = editProductService.findProductById(productId).orElseThrow();
            var category = editProductService.findCategoryByProductId(productId);
            List<ProductParameter> productParameters = editProductService.getParameterByProductId(productId);
            List<Photo> photos = editProductService.getPhotoListByProductId(productId);
            return new EditProductRequest(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(),category,
                    product.getOwnerId(), photos, productParameters);
        }
        return new EditProductRequest();
    }

    public String save(){
        System.out.println("getEditPhotoRequest.id: "+ editProductRequest.getPhotoId());
        return "/user/editProduct.xhtml?faces-redirect=true";
    }
}
