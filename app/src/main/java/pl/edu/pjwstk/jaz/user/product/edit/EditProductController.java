package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Named
@RequestScoped
public class EditProductController {
    @Inject
    private EditProductService editProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private EditProductRequest editProductRequest;
    private EditPhotoRequest editPhotoRequest;

    public EditProductRequest getEditProductRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditProductRequest();
        }
        return editProductRequest;
    }

    public EditPhotoRequest getEditPhotoRequest() {
        if (editPhotoRequest == null) {
            editPhotoRequest = new EditPhotoRequest();
        }
        return editPhotoRequest;
    }

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
//    public void changePhoto(String link){
//        editProductRequest.getPhoto().setLink(link);
//    }

//    public void showPhotoId(){
//        System.out.println("editProductRequest.id: "+ editProductRequest.getPhotoId());
//    }
    
//    public String getlink(){
//        List<Photo> photos = editProductRequest.getPhotos();
//        for (Photo p :photos) {
//            if(p.getId().equals(editProductRequest.getPhotoId())){
//                return p.getLink();
//            }
//        }
//        return "OOOOps";
//    }


    public String save(){
        //System.out.println("editPhotoRequest.id: "+ getEditProductRequest().getId());
        return "/user/listProduct.xhtml?faces-redirect=true";
    }
}
