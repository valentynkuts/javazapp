package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;


@Entity
@Table(name = "product_parametrval")
public class ProductParameter {
    @EmbeddedId
    private ProductParametrId productParametrId;

    @Column(name = "value")
    private String value;

    public ProductParameter() {
    }

    public ProductParameter(ProductParametrId productParametrId, String value) {
        this.productParametrId = productParametrId;
        this.value = value;
    }

    public ProductParametrId getProductParametrId() {
        return productParametrId;
    }

    public void setProductParametrId(ProductParametrId productParametrId) {
        this.productParametrId = productParametrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
