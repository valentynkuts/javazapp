package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductParameterId implements Serializable {
//    @ManyToOne
//    @MapsId
//    @JoinColumn
    @Column(name = "product_id")
    private Long product_id;

//    @ManyToOne
//    @MapsId
//    @JoinColumn
    @Column(name = "parameter_id")
    private Long parameter_id;

    public ProductParameterId() {
    }

    public ProductParameterId(Long product_id, Long parameter_id) {
        this.product_id = product_id;
        this.parameter_id = parameter_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(Long parameter_id) {
        this.parameter_id = parameter_id;
    }
}
