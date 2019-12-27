package pl.edu.pjwstk.jaz.user.product.add.photo;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AddPhotoController {
    @Inject
    private PhotoService photoService;

    @Inject
    private ParamRetriever paramRetriever;

    private AddPhotoRequest addPhotoRequest;


    public Long getOwnerId() {
        Long ownerid = paramRetriever.getLongUserId("id");
        return ownerid;
    }

    public AddPhotoRequest getAddPhotoRequest() {
        if (addPhotoRequest == null) {
            addPhotoRequest = new AddPhotoRequest();
        }
        return addPhotoRequest;
    }

    public List<Product> getProductListByOwnerId() {
        Long ownerId = getOwnerId();
        return photoService.getProductListByOwnerId(ownerId);
    }

    public String save() {

        Long productId = addPhotoRequest.getProductId();
        int sequence = addPhotoRequest.getSequence();
        var product = photoService.findProductById(productId).orElseThrow();

        if (!photoService.doesSequencePhotoExist(sequence, productId)) {
            photoService.save(new Photo(addPhotoRequest.getLink(), sequence, product));

            return "/user/photo/addPhoto.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Sequence of Photo exist");
            return "/user/photo/addPhoto.xhtml?faces-redirect=true";
        }
    }

}
