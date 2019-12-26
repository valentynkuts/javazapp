package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditProductController1 implements Serializable {
    private static final long serialVersionUID = 2;

    @Inject
    private EditProductService editProductService;

    @Inject
    private ParamRetriever paramRetriever;

    private EditProductRequest editProductRequest;

    public EditProductRequest getEditProductRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditProductRequest();
        }
        return editProductRequest;
    }


    private EditProductRequest createEditProductRequest() {
        if (paramRetriever.contains("productId")) {
            var productId = paramRetriever.getLong("productId");
            var product = editProductService.findProductById(productId).orElseThrow();
            var category = editProductService.findCategoryByProductId(productId);
            List<ProductParameter> productParameters = editProductService.getParameterByProductId(productId);
            List<Photo> photos = editProductService.getPhotoListByProductId(productId);
            Long version = editProductService.getVersionProduct(productId);
            //var photos = editProductService.getPhotoListByProductId(productId);
            editProductService.updateVersionProductPlusOne(productId);// update version (+1)
            return new EditProductRequest(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), category,
                    product.getOwnerId(), photos, productParameters, version);
        }
        return new EditProductRequest();
    }

    public List<Photo> getPhotoListByProductId() {
        if (getEditProductRequest().getId() != null) {
            Long productId = editProductRequest.getId();
            //System.out.println("productId:" + productId);
            return editProductService.getPhotoListByProductId(productId);
        }
        return editProductService.getPhotoListByProductId(49l);//TODO!!??
        //return new ArrayList<>(Collections.singletonList(new Photo()));
        // return editProductRequest.getPhotos();
    }

    public Photo getPhotofromListbyId() {
        System.out.println("PhotoId: " + editProductRequest.getPhotoId());  //todo
        for (Photo photo : editProductRequest.getPhotos()) {
            if (photo.getId() == editProductRequest.getPhotoId()) {
//                System.out.println("Photo link: " + photo.getLink()); //todo
//                System.out.println("photo id: " + photo.getId());
//                System.out.println("photo sequence: " + photo.getSequence());
//                System.out.println("product: " + photo.getProduct());
                return photo;
            }
        }
        return new Photo();          //TODO
    }

    public boolean doesEditedSequencePhotoExist() {
        List<Photo> photolist = editProductRequest.getPhotos();
        int size = photolist.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (photolist.get(i).getSequence() == photolist.get(j).getSequence())
                    return true;
            }
        }
        return false;
    }

    public void messageSequenceExist(){
        if(doesEditedSequencePhotoExist()) {
            System.out.println("messageSequenceExist: true");  //todo
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Sequence of Photo exist");
        } else {
            System.out.println("messageSequenceExist: false");  //todo
        }
    }

    public ProductParameter getProductParameterfromListbyId() {
        //System.out.println("PhotoId: "+editProductRequest.getPhotoId());  //todo
        for (ProductParameter productParameter : editProductRequest.getParameters()) {
            if (productParameter.getProduct().getId() == editProductRequest.getId() && productParameter.getParameter().getId() == editProductRequest.getParameterId()) {
                //System.out.println("Photo link: "+photo.getLink()); //todo
                return productParameter;
            }
        }
        return new ProductParameter();              //TODO
    }
/*

    public String save() {
//        Product product = new Product(editProductRequest.getId(),editProductRequest.getTitle(),editProductRequest.getDescription(),
//                editProductRequest.getPrice(),editProductRequest.getCategory(),editProductRequest.getOwnerId(),editProductRequest.getPhotos(),
//                editProductRequest.getParameters());

        editProductService.saveEditedProduct(new Product(editProductRequest.getId(), editProductRequest.getTitle(), editProductRequest.getDescription(),
                editProductRequest.getPrice(), editProductRequest.getCategory(), editProductRequest.getOwnerId(), editProductRequest.getPhotos(),
                editProductRequest.getParameters()));

//        editProductService.saveProduct(new Product(editProductRequest.getId(),editProductRequest.getTitle(),editProductRequest.getDescription(),
//                editProductRequest.getPrice(),editProductRequest.getCategory(),editProductRequest.getOwnerId(),editProductRequest.getPhotos(),
//                editProductRequest.getParameters()));
        return "/user/listProduct.xhtml?faces-redirect=true";
    }

*/

    public String save() {
        boolean flag = editProductService.doesVersionDifferentForOne(editProductRequest.getId(),editProductRequest.getVersion());
        Long lastVersion = editProductService.getVersionProduct(editProductRequest.getId());
        if (!doesEditedSequencePhotoExist() && flag) {
            editProductService.saveEditedProduct(new Product(editProductRequest.getId(), editProductRequest.getTitle(), editProductRequest.getDescription(),
                    editProductRequest.getPrice(), editProductRequest.getCategory(), editProductRequest.getOwnerId(), editProductRequest.getPhotos(),
                    editProductRequest.getParameters(), lastVersion));
            return "/user/listProduct.xhtml?faces-redirect=true";
        } else if(!flag){
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Version of product "+editProductRequest.getTitle()+" is out of date");
            return "/user/listProduct.xhtml?faces-redirect=true";
        }  else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Sequence of Photo of product "+editProductRequest.getTitle()+" exist");
            return "/user/listProduct.xhtml?faces-redirect=true";        }
    }
}
