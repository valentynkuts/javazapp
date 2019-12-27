package pl.edu.pjwstk.jaz.admin.category.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.category.CategoryService;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Category;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddCategoryController {
    @Inject
    private CategoryService categoryService;

    @Inject
    private ParamRetriever paramRetriever;

    private AddCategoryRequest addCategoryRequest;

    public AddCategoryRequest getAddRequest() {
        if (addCategoryRequest == null) {
            addCategoryRequest = new AddCategoryRequest();
        }
        return addCategoryRequest;
    }

    public String save() {
        Long sectionId = addCategoryRequest.getSectionId();
        String categoryName = addCategoryRequest.getName().trim();

        if (!categoryService.doesCategoryExist(categoryName, sectionId)) {
            var section = categoryService.findSectionById(sectionId).orElseThrow();
            categoryService.save(new Category(addCategoryRequest.getId(), categoryName, section));

            return "/admin/category/categoryList.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Category exist in the Section");
            return "/admin/category/addCategory.xhtml?faces-redirect=true";
        }
    }
}
