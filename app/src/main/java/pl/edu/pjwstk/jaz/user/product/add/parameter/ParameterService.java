package pl.edu.pjwstk.jaz.user.product.add.parameter;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ParameterService {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ParameterRepository parameterRepository;

    public List<Product> getProductListByOwnerId(Long ownerId) {
        return productRepository.getProductListByOwnerId(ownerId);
    }

    public List<Parameter> getParametertList() {
        return parameterRepository.getParametertList();
    }

    public void saveParameter(Parameter parameter) {
        parameterRepository.save(parameter);
    }

    public void saveProductParam(ProductParameter parameter) {
        parameterRepository.saveProductParam(parameter);
    }

    public Optional<Product> findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    public Optional<Parameter> findParameterById(Long parameterId) {
        return parameterRepository.findParameterById(parameterId);
    }

    public boolean doesParameterExist(String parameterName) {
        try {
            Parameter parameter = parameterRepository.findParameterByName(parameterName);
            if (parameter.getName().equals(parameterName))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("Parameter does not exist");
            return false;
        }
    }

    public boolean doesProductParamExist(String valueParam,Long parameterId,Long productId) {
        try {
            ProductParameter prodParameter = parameterRepository.findProductParamByIdByName(valueParam,parameterId,productId);
            if (prodParameter.getValue().equals(valueParam))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("Value of Parameter does not exist");
            return false;
        }
    }
}
