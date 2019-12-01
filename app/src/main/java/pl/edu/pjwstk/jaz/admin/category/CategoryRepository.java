package pl.edu.pjwstk.jaz.admin.category;

import pl.edu.pjwstk.jaz.product.jpa.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepository {
    @PersistenceContext
    private EntityManager em;

//    @Transactional
//    public void addCategory(String name) {
//        var category = new Category();
//        category.setName(name);
//        em.persist(category);
//    }

    @Transactional
    public void addSection(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }

    @Transactional
    public void save(Category category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }


    @Transactional
    public List<Category> getCategoryList(){
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Transactional
    public List<Category> findAll(){
        return em.createQuery("from Category", Category.class).getResultList();
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        var category = em.find(Category.class, categoryId);
        return Optional.ofNullable(category);         //TODO
    }
}
