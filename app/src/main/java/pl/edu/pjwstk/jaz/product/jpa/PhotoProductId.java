package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PhotoProductId implements Serializable {
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "photo_id")
    private Long photo_id;

    public PhotoProductId() {
    }

    public PhotoProductId(Long product_id, Long photo_id) {
        this.product_id = product_id;
        this.photo_id = photo_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Long photo_id) {
        this.photo_id = photo_id;
    }
}

