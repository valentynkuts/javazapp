package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "product_photo")
public class PhotoProduct {
    @EmbeddedId
    private PhotoProductId photoProductId;

    public PhotoProduct() {
    }

    public PhotoProduct(PhotoProductId photoProductId) {
        this.photoProductId = photoProductId;
    }

    public PhotoProductId getPhotoProductId() {
        return photoProductId;
    }

    public void setPhotoProductId(PhotoProductId photoProductId) {
        this.photoProductId = photoProductId;
    }
}
