package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductParametrId implements Serializable {
    @ManyToOne
    @MapsId
    @JoinColumn
   // @Column(name = "product_id")
    private Long product_id;

    @ManyToOne
    @MapsId
    @JoinColumn
    //@Column(name = "parametr_id")
    private Long parametr_id;

    public ProductParametrId() {
    }

    public ProductParametrId(Long product_id, Long parametr_id) {
        this.product_id = product_id;
        this.parametr_id = parametr_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getParametr_id() {
        return parametr_id;
    }

    public void setParametr_id(Long parametr_id) {
        this.parametr_id = parametr_id;
    }
}
