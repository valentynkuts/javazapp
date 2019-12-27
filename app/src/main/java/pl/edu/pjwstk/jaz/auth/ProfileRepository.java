package pl.edu.pjwstk.jaz.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(String name, String surname, String password, String email, String username, String birthday, String role) {
        var profile = new ProfileEntity(name, surname, password, email, username, birthday, role);
        em.persist(profile);

    }

    @Transactional
    public List selectListWithUsername(String username) {

//        return em.createQuery("select p from ProfileEntity p where p.username = 'test1234'", ProfileEntity.class)
//                //.setParameter(1, username)
//                .getResultList();

//        return em.createQuery("select p from ProfileEntity p where p.username = ?1", ProfileEntity.class)
//                .setParameter(1, username)
//                .getResultList();

        return em.createQuery("select p from ProfileEntity p where p.username = :username", ProfileEntity.class)
                .setParameter("username", username)
                .getResultList();
    }

    @Transactional
    public ProfileEntity selectSingleResWithUsername(String username) {

        return em.createQuery("select p from ProfileEntity p where p.username = :username", ProfileEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Transactional
    public ProfileEntity selectProfileEntityWhereId1() {
        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 1L);
        return profileEntity;
    }

    @Transactional
    public ProfileEntity selectProfileEntityById(long id) {
        final ProfileEntity profileEntity = em.find(ProfileEntity.class, id);
        return profileEntity;
    }

    @Transactional
    public ProfileEntity selectSingleResWithUsernamePassw(String username, String password) {

        return em.createQuery("select p from ProfileEntity p where p.username = :username and p.password = :password", ProfileEntity.class)
                .setParameter("username", username).setParameter("password", password)
                .getSingleResult();
    }

}
