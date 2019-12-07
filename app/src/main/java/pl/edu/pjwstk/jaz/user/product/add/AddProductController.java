package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.add.AddCategoryRequest;
import pl.edu.pjwstk.jaz.product.jpa.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AddProductController {
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
        if(getAddRequest().getSectionId() != null) {
            // System.out.println("-------------  " + addProductRequest.getCategory().getSection().getId() + "  -----------------");
            Long sectionId = getAddRequest().getSectionId();
            return productService.findCategoryBySectionId(sectionId);
        }
        return productService.findCategoryBySectionId(3l);
    }

    public String save() {
//        var section = categoryService.findSectionById(addCategoryRequest.getSectionId()).orElseThrow();
//        categoryService.save(new Category(addCategoryRequest.getId(), addCategoryRequest.getName(),section));

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }


}
