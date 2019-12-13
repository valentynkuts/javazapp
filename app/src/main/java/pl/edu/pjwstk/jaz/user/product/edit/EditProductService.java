package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.product.jpa.*;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;
import pl.edu.pjwstk.jaz.user.product.add.parameter.ParameterRepository;
import pl.edu.pjwstk.jaz.user.product.add.photo.PhotoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EditProductService {
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

    public List<Photo> getPhotoListByProductId(Long productId) {
        return photoRepository.getPhotoListByProductId(productId);
    }

    public List<ProductParameter> getParameterByProductId(Long productId) {
        return parameterRepository.getParameterByProductId(productId);
    }

    public Category findCategoryByProductId(Long productId){
        return productRepository.findCategoryByProductId(productId);
    }

    public Optional<Product> findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }
}
