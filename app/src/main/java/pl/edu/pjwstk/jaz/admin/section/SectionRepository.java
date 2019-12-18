package pl.edu.pjwstk.jaz.admin.section;

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
    public Long getSectionMinId(){
        return em.createQuery("select min(s.id) from Section s", Long.class).getSingleResult();

    }

    @Transactional
    public Section getSectionByMinId(){
        return em.createQuery("select s from Section s where s.id = (select min(s.id) from Section s)", Section.class).getSingleResult();

    }

    @Transactional
    public List<Section> getSectionList(){
        return em.createQuery("select s from Section s", Section.class).getResultList();
    }

    @Transactional
    public List<Section> findAll(){
        return em.createQuery("from Section", Section.class).getResultList();
    }

    @Transactional
    public Optional<Section> findSectionById(Long sectionId) {
        var section = em.find(Section.class, sectionId);
        return Optional.ofNullable(section);
    }

    @Transactional
    public Section getSectionReference(Long sectionId) {
        return em.getReference(Section.class, sectionId);
    }

    @Transactional
    public Section findSectionByName(String sectionName) {
        return em.createQuery("select s from Section s where s.name = :sectionName", Section.class)
                .setParameter("sectionName", sectionName)
                .getSingleResult();
    }
    @Transactional
    public Optional<Section> findSectionByName2(String sectionName) {
            return Optional.ofNullable(findSectionByName(sectionName));

    }

    @Transactional
    public Optional<Section> findSectionByName3(String sectionName) {
        return Optional.ofNullable(em.createQuery("select s from Section s where s.name = :sectionName", Section.class)
                .setParameter("sectionName", sectionName)
                .getSingleResult());
    }

}
