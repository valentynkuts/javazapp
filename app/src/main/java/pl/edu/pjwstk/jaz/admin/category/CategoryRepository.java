package pl.edu.pjwstk.jaz.admin.category;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

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
    public List<Category> getCategoryList() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Transactional
    public List<Category> findAll() {
        return em.createQuery("from Category", Category.class).getResultList();
    }

    @Transactional
    public Optional<Category> findCategoryById(Long categoryId) {
        var category = em.find(Category.class, categoryId);
        return Optional.ofNullable(category);         //TODO
    }

    @Transactional
    public List<Category> findCategoryBySectionId(Long sectionId) {

//        return em.createQuery("select c from Category c where c.section_id = ?1", Category.class)
//                .setParameter(1, sectionId)
//                .getResultList();
        return em.createQuery("select c from Category c where c.section.id = :sectionId", Category.class)
                .setParameter("sectionId", sectionId)
                .getResultList();
    }

    @Transactional
    public List<Section> getSectionListFromCategory() {
        return em.createQuery("select distinct s from Section s join Category c on c.section.id = s.id", Section.class).getResultList();
    }

    @Transactional
    public Section getSectionFromCategory1(Long categoryId) {
        return em.createQuery("select s from Section s where s.id = (select c.section.id from Category c where c.id = :categoryId)", Section.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();
    }

    @Transactional
    public Optional<Section> getSectionFromCategory(Long categoryId) {
        var section = em.createQuery("select s from Section s where s.id = (select c.section.id from Category c where c.id = :categoryId)", Section.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();
        return Optional.ofNullable(section);


    }

}
