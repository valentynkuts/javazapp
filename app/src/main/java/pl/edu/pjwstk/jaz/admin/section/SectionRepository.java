package pl.edu.pjwstk.jaz.admin.section;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SectionRepository {
    @PersistenceContext
    private EntityManager em;

//    @Transactional
//    public void addSection(String name) {
//        var section = new Section();
//        section.setName(name);
//        em.persist(section);
//    }

    @Transactional
    public void addSection(Section section) {
        if (section.getId() == null) {
            em.persist(section);
        } else {
            em.merge(section);
        }
    }

    @Transactional
    public void save(Section section) {
        if (section.getId() == null) {
            em.persist(section);
        } else {
            em.merge(section);
        }
    }


    @Transactional
    public List<Section> getSectionList(){
        return em.createQuery("select s from Section s", Section.class).getResultList();
    }

    @Transactional
    public List<Section> findAll(){
        return em.createQuery("from Section", Section.class).getResultList();
    }

    public Optional<Section> findSectionById(Long sectionId) {
        var section = em.find(Section.class, sectionId);
        return Optional.ofNullable(section);         //TODO
    }

//    public List<Door> findAll() {
//        return em.createQuery("from Door", Door.class).getResultList();
//    }
}
