package pl.edu.pjwstk.jaz.user.product.list;

import org.springframework.security.access.method.P;
import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.logging.Handler;

@Named
@RequestScoped
public class ListProductController {
    @Inject
    private ListProductService listProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private ProductRequest productRequest;

    public Long getOwnerId() {
        return paramRetriever.getLongUserId("id");
    }
    public ProductRequest getProductRequest() {
        if (productRequest == null) {
            productRequest = new ProductRequest();
        }
        return productRequest;
    }

    public List<Product> getProductListByOwnerId() {
        Long ownerId = getOwnerId();
        return listProductService.getProductListByOwnerId(ownerId);

    }

    public List<ProductParameter> getProductParameterByProductId(Long productId) {
        return listProductService.getProductParameterByProductId(productId);
    }

    public List<Parameter> getParameterByParamId(Long parameterId) {
        return listProductService.getParameterByParamId(parameterId);
    }

    public List<Photo> getPhotoListByProductId(Long productId) {
        return listProductService.getPhotoListByProductId(productId);
    }

    public Photo getPhotoByProductIdMinSequence1(Long productId) {
        return listProductService.getPhotoByProductIdMinSequence1(productId);
    }

    public List<Photo> getPhotoByProductIdMinSequence(Long productId) {
        return listProductService.getPhotoByProductIdMinSequence(productId);
    }

    public Photo getFirstPhotoFromList1(Long productId){
        List<Photo> photoList = getPhotoListByProductId(productId);
        Photo firstPhoto =  photoList.get(0);
        return firstPhoto;
    }

    public Photo getFirstPhotoFromList2(Long productId){
        List<Photo> photoList = getPhotoListByProductId(productId);
//        Optional<Photo> firstElement = photoList.stream().findFirst();
        Photo firstElement = photoList.stream().findFirst().orElseThrow();
        return firstElement;
    }

    public List<Photo> getFirstPhotoFromList(Long productId){
        List<Photo> photoList = getPhotoListByProductId(productId);
//        Optional<Photo> firstElement = photoList.stream().findFirst();
       // Photo firstElement1 = photoList.stream().findFirst().orElseThrow();
        Photo firstPhoto =  photoList.get(0);

        List<Photo> firstElement = new ArrayList<>(Collections.singletonList(firstPhoto));
        return firstElement;
    }

    public List<ProductParameter> getParameterByProductId(Long productId) {
        return listProductService.getParameterByProductId(productId);
    }

}
