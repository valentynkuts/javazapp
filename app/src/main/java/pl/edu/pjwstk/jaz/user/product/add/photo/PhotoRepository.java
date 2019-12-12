package pl.edu.pjwstk.jaz.user.product.add.photo;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PhotoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Photo photo) {
        if (photo.getId() == null) {
            em.persist(photo);
        } else {
            em.merge(photo);
        }
    }

    @Transactional
    public List<Photo> getPhotoListByProductId(Long productId) {
        return em.createQuery("select p from Photo p where p.product.id = :productId", Photo.class)
                .setParameter("productId", productId)
                .getResultList();
    }

}
