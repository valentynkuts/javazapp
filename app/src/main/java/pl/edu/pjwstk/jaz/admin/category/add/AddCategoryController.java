package pl.edu.pjwstk.jaz.admin.category.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.category.edit.EditCategoryRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddCategoryController {
    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ParamRetriever paramRetriever;

    // @Inject
    private AddCategoryRequest addCategoryRequest;

    public AddCategoryRequest getAddRequest() {
        if (addCategoryRequest == null) {
            addCategoryRequest = createEditCategoryRequest();
        }
        return addCategoryRequest;
    }

    private AddCategoryRequest createEditCategoryRequest() {
        if (paramRetriever.contains("categoryId")) {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryRepository.findCategoryById(categoryId).orElseThrow();  //TODO
            return new AddCategoryRequest(category);
        }
        return new AddCategoryRequest();
    }

    public String save() {
        var category = addCategoryRequest.toCategory();
        categoryRepository.save(category);

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }
}
