package pl.edu.pjwstk.jaz.user.product.add.parameter;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ParameterService {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private ParameterRepository parameterRepository;

    public List<Product> getProductListByOwnerId(Long ownerId){
        return productRepository.getProductListByOwnerId(ownerId);
    }

    public void saveParameter(Parameter parameter){
        parameterRepository.save(parameter);
    }

}
