package pl.edu.pjwstk.jaz.product;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
class ProductParametrPk implements Serializable {
    private Long product_id;
    private Long parametr_id;

    public ProductParametrPk() {
    }

    public ProductParametrPk(Long product_id, Long parametr_id) {
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

@Entity
@Table(name = "product_parametrval")
public class ProductParametrValEntity {
    @EmbeddedId
    private ProductParametrPk productParametrPk;

    private String value_param;

    public ProductParametrValEntity() {
    }

    public ProductParametrValEntity(ProductParametrPk productParametrPk, String value_param) {
        this.productParametrPk = productParametrPk;
        this.value_param = value_param;
    }

    public ProductParametrPk getProductParametrPk() {
        return productParametrPk;
    }

    public void setProductParametrPk(ProductParametrPk productParametrPk) {
        this.productParametrPk = productParametrPk;
    }

    public String getValue_param() {
        return value_param;
    }

    public void setValue_param(String value_param) {
        this.value_param = value_param;
    }
}
