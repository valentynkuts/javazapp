package pl.edu.pjwstk.jaz.product;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
class ProductPhotoPk implements Serializable {
    private Long product_id;
    private Long photo_id;

    public ProductPhotoPk() {
    }

    public ProductPhotoPk(Long product_id, Long photo_id) {
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

@Entity
@Table(name = "product_photo")
public class PhotoOfProductEntity {
    @EmbeddedId
    private ProductPhotoPk productPhotoPk;

    public PhotoOfProductEntity() {
    }

    public PhotoOfProductEntity(ProductPhotoPk productPhotoPk) {
        this.productPhotoPk = productPhotoPk;
    }

    public ProductPhotoPk getProductPhotoPk() {
        return productPhotoPk;
    }

    public void setProductPhotoPk(ProductPhotoPk productPhotoPk) {
        this.productPhotoPk = productPhotoPk;
    }
}
