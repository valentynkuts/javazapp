package pl.edu.pjwstk.jaz.admin;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SectionCategoryRepository {

//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional
//    public void addSection(String name) {
//        var section = new Section();
//        section.setName(name);
//        em.persist(section);
//    }
//    @Transactional
//    public void addCategory(String name) {
//        var category = new Category();
//        category.setName(name);
//        em.persist(category);
//    }
//
//    @Transactional
//    public List<Section> getSectionList(){
//
//        return em.createQuery("select s from Section s", Section.class).getResultList();
//
//       //// List<SectionEntity> sectionList = new ArrayList<>();
//
//       //// return sectionList;
//    }
}
