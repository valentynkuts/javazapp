package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.product.jpa.*;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;
import pl.edu.pjwstk.jaz.user.product.add.parameter.ParameterRepository;
import pl.edu.pjwstk.jaz.user.product.add.photo.PhotoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

    public Category findCategoryByProductId(Long productId) {
        return productRepository.findCategoryByProductId(productId);
    }

    public Optional<Product> findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    @Transactional
    public void saveEditedProduct(Product product) {
//        productRepository.save(new Product(product.getId(),product.getTitle(), product.getDescription(),
//                product.getPrice(), product.getOwnerId(), product.getCategory()));
        productRepository.save(product);


        for (ProductParameter productParameter : product.getParameters()) {
//            parameterRepository.saveEditedProductParam(new ProductParameter(productParameter.getProduct(), productParameter.getParameter(),
//                    productParameter.getValue()));
            parameterRepository.saveEditedProductParam(productParameter);
        }

        for (Photo photo : product.getPhotos()) {
            System.out.println("photo id: " + photo.getId());
            System.out.println("photo link: " + photo.getLink());
            System.out.println("photo sequence: " + photo.getSequence());
            System.out.println("product: " + product);
            // photoRepository.save(new Photo(photo.getId(),photo.getLink(), photo.getSequence(), product));

            photoRepository.save(photo);

        }


    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }//todo

    public void updateVersionProductPlusOne(Long productId) {
        productRepository.updateVersionProductPlusOne(productId);
    }

    public Long getVersionProduct(Long productId) {
        return productRepository.getVersionProduct(productId);
    }

    public boolean doesVersionDifferentForOne(Long productId,Long currentVersion){
        Long updatedVersion = productRepository.getVersionProduct(productId);
        long diff = updatedVersion - currentVersion;
        return (diff == 1);
    }
}

