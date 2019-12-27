package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Product> getProductListByOwnerId(Long ownerId) {
        return em.createQuery("select p from Product p where p.ownerId = :ownerId", Product.class)
                .setParameter("ownerId", ownerId)
                .getResultList();
    }

    @Transactional
    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    @Transactional
    public Optional<Product> findProductById(Long productId) {
        var product = em.find(Product.class, productId);
        return Optional.ofNullable(product);         //TODO
    }

    @Transactional
    public Category findCategoryByProductId(Long productId) {
        return em.createQuery("select c from Category c where c.id in(select p.category.id from Product p where p.id = :productId)", Category.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

    @Transactional
    public Category findCategoryByProductId1(Long productId) {
        return em.createQuery("select c from Category c join Product p on c.id = (select p.category.id from Product p where p.id = :productId)", Category.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

    @Transactional
    public void updateVersionProductPlusOne(Long productId){
        em.createQuery("update Product p set p.version = p.version + 1 where p.id = :productId")
                .setParameter("productId", productId)
                .executeUpdate();
    }

    @Transactional
    public Long getVersionProduct(Long productId){
       return em.createQuery("select p.version from Product p where p.id = :productId", Long.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

}
