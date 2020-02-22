package pl.edu.pjwstk.jaz.basket.jpa;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BasketRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Product> getAllProducts() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Transactional
    public void addBasket(Basket basket) {
        if (basket.getId() == null) {
            em.persist(basket);
        } else {
            em.merge(basket);
        }
    }

    @Transactional
    public void addBasketItem(BasketItem basketItem) {
            em.persist(basketItem);
    }

    @Transactional
    public void changeBasketItem(BasketItem basketItem) {
        em.merge(basketItem);
    }

    @Transactional
    public Optional<Basket> findBasketByUserId(Long userId) {
        //var basket = em.find(Basket.class, userId);
        try {
            var basket = em.createQuery("select b from Basket b where b.userId = :userId", Basket.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
            return Optional.ofNullable(basket);
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

    @Transactional
    public Optional<BasketItem> getBasketItemByProductIdBasketId(Long productId, Long basketId) {
        try {
            var basketItems = em.createQuery("select b from BasketItem b where b.product.id = :productId and b.basket.id = :basketId", BasketItem.class)
                    .setParameter("productId", productId).setParameter("basketId", basketId)
                    .getSingleResult();
            return Optional.ofNullable(basketItems);
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }

}
