package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Product> getProductListByOwnerId(Long ownerId){
        return em.createQuery("select p from Product p where p.ownerId = :ownerId", Product.class)
                .setParameter("ownerId", ownerId)
                .getResultList();
    }
}