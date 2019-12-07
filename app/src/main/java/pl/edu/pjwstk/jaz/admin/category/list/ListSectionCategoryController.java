package pl.edu.pjwstk.jaz.admin.category.list;

import pl.edu.pjwstk.jaz.admin.category.CategoryService;
import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class ListSectionCategoryController {
    @Inject
    private CategoryService categoryService;

    public List<Category> getCategoryListBySectionId(Long sectionId) {
        System.out.println("-------------  " + sectionId + "  -----------------");
        return categoryService.findCategoryBySectionId(sectionId);
    }

    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public List<Section> getSectionListFromCategory(){
        return categoryService.getSectionListFromCategory();
    }

}
