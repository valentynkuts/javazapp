package pl.edu.pjwstk.jaz.admin.section.list;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;
import pl.edu.pjwstk.jaz.user.product.add.parameter.ParameterRepository;
import pl.edu.pjwstk.jaz.user.product.add.photo.PhotoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ListProductService {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private PhotoRepository photoRepository;
    @Inject
    private ParameterRepository parameterRepository;


    public List<Product> getProductListByOwnerId(Long ownerId) {
        return productRepository.getProductListByOwnerId(ownerId);

    }

    public List<ProductParameter> getProductParameterByProductId(Long productId) {
       return parameterRepository.getProductParameterByProductId(productId);
    }

    public List<Parameter> getParameterByParamId(Long parameterId) {
        return parameterRepository.getParameterByParamId(parameterId);
    }
}