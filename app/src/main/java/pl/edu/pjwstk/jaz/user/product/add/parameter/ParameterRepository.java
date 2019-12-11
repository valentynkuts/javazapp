package pl.edu.pjwstk.jaz.user.product.add.parameter;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ParameterRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Parameter parameter) {
        if (parameter.getId() == null) {
            em.persist(parameter);
        } else {
            em.merge(parameter);
        }
    }
}
