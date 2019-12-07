package pl.edu.pjwstk.jaz.admin.category.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.CategoryService;
import pl.edu.pjwstk.jaz.product.jpa.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditCategoryController {

    @Inject
    private CategoryService categoryService;

    @Inject
    private ParamRetriever paramRetriever;

    private EditCategoryRequest editCategoryRequest;

    public EditCategoryRequest getEditRequest() {
        if (editCategoryRequest == null) {
            editCategoryRequest = createEditCategoryRequest();
            System.out.println("getEditRequest:"+editCategoryRequest.getId()+"   "+editCategoryRequest.getName()+"  "+editCategoryRequest.getSection());
        }
        return editCategoryRequest;
    }

    private EditCategoryRequest createEditCategoryRequest() {
        if (paramRetriever.contains("categoryId")) {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryService.findCategoryById(categoryId).orElseThrow();  //TODO
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

    public String save() {
       // System.out.println("save1:"+editCategoryRequest.getId()+"   "+editCategoryRequest.getName()+"  "+editCategoryRequest.getSection());

       var section = categoryService.getSectionFromCategory(editCategoryRequest.getId()).orElseThrow();
        categoryService.save(new Category(editCategoryRequest.getId(), editCategoryRequest.getName(),section));

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }
}
