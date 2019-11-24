package pl.edu.pjwstk.jaz.admin;

import pl.edu.pjwstk.jaz.product.CategoryEntity;
import pl.edu.pjwstk.jaz.product.SectionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SectionCategoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addSection(String name) {
        var section = new SectionEntity();
        section.setName(name);
        em.persist(section);
    }
    @Transactional
    public void addCategory(String name) {
        var category = new CategoryEntity();
        category.setName(name);
        em.persist(category);
    }

    @Transactional
    public List<SectionEntity> getSectionList(){

        return em.createQuery("select s from SectionEntity s", SectionEntity.class).getResultList();

       //// List<SectionEntity> sectionList = new ArrayList<>();

       //// return sectionList;
    }
}
