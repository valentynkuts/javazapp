package pl.edu.pjwstk.jaz.basket.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class BasketRepository {
    @PersistenceContext
    private EntityManager em;

}
