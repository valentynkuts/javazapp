package pl.edu.pjwstk.jaz.user.product.edit;

import liquibase.structure.core.Column;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
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
    @Inject
    private CategoryRepository categoryRepository;


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
        productRepository.save(product);

        for (ProductParameter productParameter : product.getParameters()) {
            parameterRepository.saveEditedProductParam(productParameter);
        }

        for (Photo photo : product.getPhotos()) {
            photoRepository.save(photo);
        }
    }

//    public void saveProduct(Product product) {
//        productRepository.save(product);
//    }//todo

    public void updateVersionProductPlusOne(Long productId) {
        productRepository.updateVersionProductPlusOne(productId);
    }

    public Long getVersionProduct(Long productId) {
        return productRepository.getVersionProduct(productId);
    }

    public boolean doesVersionDifferentForOne(Long productId, Long currentVersion) {
        Long updatedVersion = productRepository.getVersionProduct(productId);
        long diff = updatedVersion - currentVersion;
        return (diff == 1);
    }

    public List<Category> findCategoryBySectionId(Long sectionId) {
        return categoryRepository.findCategoryBySectionId(sectionId);
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    public boolean doesCategoryChosen(Long categoryId) {
        Optional<Category> category = categoryRepository.findCategoryById(categoryId);
        return category.isPresent();
    }
}

