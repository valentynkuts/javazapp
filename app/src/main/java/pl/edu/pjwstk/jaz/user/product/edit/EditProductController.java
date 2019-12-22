package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Named
//@RequestScoped
@ManagedBean
@ViewScoped
public class EditProductController implements Serializable {
    private static final long serialVersionUID = 2;

    @Inject
    private EditProductService editProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private EditProductRequest editProductRequest;
   // private EditPhotoRequest editPhotoRequest;

    public EditProductRequest getEditProductRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditProductRequest();
        }
        return editProductRequest;
    }

//    public EditPhotoRequest getEditPhotoRequest() {
//        if (editPhotoRequest == null) {
//            editPhotoRequest = new EditPhotoRequest();
//        }
//        return editPhotoRequest;
//    }

    private EditProductRequest createEditProductRequest() {
        if (paramRetriever.contains("productId")) {
            var productId = paramRetriever.getLong("productId");
            var product = editProductService.findProductById(productId).orElseThrow();
            var category = editProductService.findCategoryByProductId(productId);
            List<ProductParameter> productParameters = editProductService.getParameterByProductId(productId);
            List<Photo> photos = editProductService.getPhotoListByProductId(productId);
            //var photos = editProductService.getPhotoListByProductId(productId);
            return new EditProductRequest(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(),category,
                    product.getOwnerId(), photos, productParameters);
        }
        return new EditProductRequest();
    }

    public List<Photo> getPhotoListByProductId(){
        if(getEditProductRequest().getId()!=null) {
            Long productId = editProductRequest.getId();
            //System.out.println("productId:" + productId);
            return editProductService.getPhotoListByProductId(productId);
        }
        return editProductService.getPhotoListByProductId(49l);//TODO
        //return new ArrayList<>(Collections.singletonList(new Photo()));
        // return editProductRequest.getPhotos();
    }

    public Photo getPhotofromListbyId(){
        System.out.println("PhotoId: "+editProductRequest.getPhotoId());  //todo
        for (Photo photo: editProductRequest.getPhotos()) {
            if (photo.getId() == editProductRequest.getPhotoId()) {
                System.out.println("Photo link: "+photo.getLink()); //todo
                System.out.println("photo id: "+photo.getId());
                System.out.println("photo sequence: "+photo.getSequence());
                System.out.println("product: "+photo.getProduct());
                return photo;
            }
        }

        return new Photo();          //TODO
    }

    public ProductParameter getProductParameterfromListbyId(){
        //System.out.println("PhotoId: "+editProductRequest.getPhotoId());  //todo
        for (ProductParameter productParameter: editProductRequest.getParameters()) {
            if (productParameter.getProduct().getId() == editProductRequest.getId() && productParameter.getParameter().getId() == editProductRequest.getParameterId()) {
                //System.out.println("Photo link: "+photo.getLink()); //todo
                return productParameter;
            }
        }
        return new ProductParameter();              //TODO
    }

    public String save(){
//        Product product = new Product(editProductRequest.getId(),editProductRequest.getTitle(),editProductRequest.getDescription(),
//                editProductRequest.getPrice(),editProductRequest.getCategory(),editProductRequest.getOwnerId(),editProductRequest.getPhotos(),
//                editProductRequest.getParameters());

        editProductService.saveEditedProduct(new Product(editProductRequest.getId(),editProductRequest.getTitle(),editProductRequest.getDescription(),
                editProductRequest.getPrice(),editProductRequest.getCategory(),editProductRequest.getOwnerId(),editProductRequest.getPhotos(),
                editProductRequest.getParameters()));

//        editProductService.saveProduct(new Product(editProductRequest.getId(),editProductRequest.getTitle(),editProductRequest.getDescription(),
//                editProductRequest.getPrice(),editProductRequest.getCategory(),editProductRequest.getOwnerId(),editProductRequest.getPhotos(),
//                editProductRequest.getParameters()));
        return "/user/listProduct.xhtml?faces-redirect=true";
    }
}