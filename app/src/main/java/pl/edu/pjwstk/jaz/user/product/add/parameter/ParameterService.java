package pl.edu.pjwstk.jaz.user.product.add.parameter;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
}
