package pl.edu.pjwstk.jaz.admin.category;

import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryService {
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private SectionRepository sectionRepository;

    public Optional<Section> findSectionById(Long sectionId) {
        return sectionRepository.findSectionById(sectionId);

    }

    public Optional<Category> findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    public List<Category> findCategoryBySectionId(Long sectionId) {
        return categoryRepository.findCategoryBySectionId(sectionId);

    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Section> getSectionList() {
        return sectionRepository.findAll();
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Section> getSectionListFromCategory() {
        return categoryRepository.getSectionListFromCategory();
    }

    public Section getSectionFromCategory1(Long categoryId) {
        return categoryRepository.getSectionFromCategory1(categoryId);
    }

    public Optional<Section> getSectionFromCategory(Long categoryId) {
        return categoryRepository.getSectionFromCategory(categoryId);
    }

    public boolean doesCategoryExist(String categoryName, Long sectionId) {
        try {
            List<Category> categoryList = categoryRepository.findCategoryBySectionId(sectionId);
            for (Category c : categoryList) {
                if (c.getName().equals(categoryName))
                    return true;
            }
            return false;
        } catch (NoResultException nre) {
            System.out.println("Category does not exist");
            return false;
        }
    }

}
