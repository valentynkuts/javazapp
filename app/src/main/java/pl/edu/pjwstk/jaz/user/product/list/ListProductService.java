package pl.edu.pjwstk.jaz.user.product.list;

import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
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

    public List<Photo> getPhotoListByProductId(Long productId) {
        return photoRepository.getPhotoListByProductId(productId);
    }

    public Photo getPhotoByProductIdMinSequence2(Long productId) {
        return photoRepository.getPhotoByProductIdMinSequence2(productId);
    }
    public List<Photo> getPhotoByProductIdMinSequence(Long productId) {
        return photoRepository.getPhotoByProductIdMinSequence(productId);
    }

    public List<ProductParameter> getParameterByProductId(Long productId) {
        return parameterRepository.getParameterByProductId(productId);
    }
}