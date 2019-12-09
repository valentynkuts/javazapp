package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private SectionRepository sectionRepository;
    @Inject
    private ProductRepository productRepository;

    public List<Category> findCategoryBySectionId(Long sectionId){
        return categoryRepository.findCategoryBySectionId(sectionId);
    }
    public List<Product>  getProductListByOwnerId(Long ownerId){
        return productRepository.getProductListByOwnerId(ownerId);

    }
}
