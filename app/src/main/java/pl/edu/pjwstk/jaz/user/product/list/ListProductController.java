package pl.edu.pjwstk.jaz.user.product.list;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

@Named
@RequestScoped
public class ListProductController {
    @Inject
    private ListProductService listProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private ProductRequest productRequest;
    private HashMap<Integer,ProductRequest> ListProductRequest;

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

    public List<ProductParameter> getParameterByProductId(Long productId) {
        return listProductService.getParameterByProductId(productId);
    }

}
