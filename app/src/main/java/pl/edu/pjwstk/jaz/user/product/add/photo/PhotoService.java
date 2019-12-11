package pl.edu.pjwstk.jaz.user.product.add.photo;

import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.user.product.add.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PhotoService {
    @Inject
    private ProductRepository productRepository;
    @Inject
    private PhotoRepository photoRepository;

    public List<Product> getProductListByOwnerId(Long ownerId){
        return productRepository.getProductListByOwnerId(ownerId);

    }

    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public Optional<Product> findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }



}
