package pl.edu.pjwstk.jaz.admin.category.edit;

import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.section.edit.EditSectionRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditCategoryController {
    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ParamRetriever paramRetriever;

    // @Inject
    private EditCategoryRequest editCategoryRequest;

    public EditCategoryRequest getEditRequest() {
        if (editCategoryRequest == null) {
            editCategoryRequest = createEditCategoryRequest();
        }
        return editCategoryRequest;
    }

    private EditCategoryRequest createEditCategoryRequest() {
        if (paramRetriever.contains("categoryId")) {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryRepository.findCategoryById(categoryId).orElseThrow();  //TODO
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

    public String save() {
        var category = editCategoryRequest.toCategory();
        categoryRepository.save(category);

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }
}
