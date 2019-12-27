package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Category;
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
public class EditProductController implements Serializable {
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

//    public List<Photo> getPhotoListByProductId() {
//        if (getEditProductRequest().getId() != null) {
//            Long productId = editProductRequest.getId();
//            return editProductService.getPhotoListByProductId(productId);
//        }
//        return editProductService.getPhotoListByProductId(49l);//TODO!!??
//    }

    public Photo getPhotofromListbyId() {
        for (Photo photo : editProductRequest.getPhotos()) {
            if (photo.getId() == editProductRequest.getPhotoId()) {
                editProductRequest.setTempPhoto(photo);
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

    public void messageSequenceExist() {
        if (doesEditedSequencePhotoExist()) {
            System.out.println("messageSequenceExist: true");  //todo
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Sequence of Photo exist");
        } else {
            System.out.println("messageSequenceExist: false");  //todo
        }
    }

    public ProductParameter getProductParameterfromListbyId() {
        for (ProductParameter productParameter : editProductRequest.getParameters()) {
            if (productParameter.getProduct().getId() == editProductRequest.getId() && productParameter.getParameter().getId() == editProductRequest.getParameterId()) {
                return productParameter;
            }
        }
        return new ProductParameter();              //TODO
    }

    public List<Category> getCategoryListBySectionId() {
        Long sectionId = getEditProductRequest().getSectionId();
        return editProductService.findCategoryBySectionId(sectionId);
    }

    public boolean statePhotoIdLink(Photo photo) {
        if (editProductRequest.getPhotoId() != null && photo.getLink().isBlank())
            return true;
        return false;

    }

    public boolean statePhotoIdSequence(Photo photo) {
        if ((editProductRequest.getPhotoId() != null) && (photo.getSequence() <= 0L)) {
            System.out.println("editProductRequest.getPhotoId(): " + editProductRequest.getPhotoId());
            System.out.println("photo.getSequence(): " + photo.getSequence());
            System.out.println("true");
            return true;

        } else {
            System.out.println("editProductRequest.getPhotoId(): " + editProductRequest.getPhotoId());
            System.out.println("photo.getSequence(): " + photo.getSequence());
            System.out.println("false");
            return false;

        }

    }

    public boolean stateParameterIdValue(ProductParameter productParameter) {
        if (editProductRequest.getParameterId() != null && productParameter.getValue().isBlank())
            return true;
        return false;
    }

    public String save() {

        boolean flag = editProductService.doesVersionDifferentForOne(editProductRequest.getId(), editProductRequest.getVersion());
        Long lastVersion = editProductService.getVersionProduct(editProductRequest.getId());

        if (!doesEditedSequencePhotoExist() && flag) {

            if (editProductRequest.getCategoryId() != null) {
//                if (editProductService.doesCategoryChosen(editProductRequest.getCategoryId())) {
//                    Category category = editProductService.findCategoryById(editProductRequest.getCategoryId()).orElseThrow();
//                    editProductRequest.setCategory(category);
//                }
                Category category = editProductService.findCategoryById(editProductRequest.getCategoryId()).orElseThrow();
                editProductRequest.setCategory(category);
            }

            editProductService.saveEditedProduct(new Product(editProductRequest.getId(), editProductRequest.getTitle(), editProductRequest.getDescription(),
                    editProductRequest.getPrice(), editProductRequest.getCategory(), editProductRequest.getOwnerId(), editProductRequest.getPhotos(),
                    editProductRequest.getParameters(), lastVersion));
            return "/user/listProduct.xhtml?faces-redirect=true";

        } else if (!flag) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Version of product " + editProductRequest.getTitle() + " is out of date");
            return "/user/listProduct.xhtml?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Sequence " + editProductRequest.getTempPhoto().getSequence() +
                            " of Photo " + editProductRequest.getTempPhoto().getLink() + " of product " + editProductRequest.getTitle() + " exist." +
                            " Please edit again.");
            return "/user/listProduct.xhtml?faces-redirect=true";
        }
    }
}
