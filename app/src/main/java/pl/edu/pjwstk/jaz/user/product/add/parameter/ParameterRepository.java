package pl.edu.pjwstk.jaz.user.product.add.parameter;

import org.springframework.security.access.method.P;
import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void saveProductParam(ProductParameter parameter) {
        em.persist(parameter);
//        if ((parameter.getParameter() == null) && (parameter.getProduct() == null)) {
//            em.persist(parameter);
//        } else {
//            em.merge(parameter);
//        }
    }

    @Transactional
    public List<Parameter> getParametertList(){
        return em.createQuery("select p from Parameter p", Parameter.class).getResultList();
    }

    @Transactional
    public Optional<Parameter> findParameterById(Long parameterId) {
        var parameter = em.find(Parameter.class, parameterId);
        return Optional.ofNullable(parameter);
    }

    @Transactional
    public List<ProductParameter> getProductParameterByProductId(Long productId) {
        return em.createQuery("select p from ProductParameter p where p.product.id = :productId", ProductParameter.class)
                .setParameter("productId", productId)
                .getResultList();
    }

    @Transactional
    public List<Parameter> getParameterByParamId(Long parameterId) {
        return em.createQuery("select p from Parameter p where p.parameter.id = :parameterId", Parameter.class)
                .setParameter("parameterId", parameterId)
                .getResultList();
    }

    @Transactional
    public List<ProductParameter> getParameterByProductId(Long productId) {
        return em.createQuery("select pp from ProductParameter pp join Parameter p on pp.parameter.id = p.id and pp.product.id = :productId", ProductParameter.class)
                .setParameter("productId", productId)
                .getResultList();
    }

}
