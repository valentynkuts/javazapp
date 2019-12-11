package pl.edu.pjwstk.jaz.user.product.add.photo;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.RequestScoped;
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

    public List<Product> getProductListByOwnerId(){
        Long ownerId = getOwnerId();
        return photoService.getProductListByOwnerId(ownerId);

    }

    public String save() {

        System.out.println("Product id: "+addPhotoRequest.getProductId());
        System.out.println("Photo link: "+addPhotoRequest.getLink());
        System.out.println("Sequence of photo: "+addPhotoRequest.getSequence());


       var product = photoService.findProductById(addPhotoRequest.getProductId()).orElseThrow();
        photoService.save(new Photo(addPhotoRequest.getLink(),addPhotoRequest.getSequence(),product));

        return "/user/photo/addPhoto.xhtml?faces-redirect=true";
    }

}
