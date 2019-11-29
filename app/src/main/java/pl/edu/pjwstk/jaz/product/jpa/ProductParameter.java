package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;


@Entity
@Table(name = "product_parameter")
public class ProductParameter {
    @EmbeddedId
    private ProductParameterId productParameterId;

    //---------TODO------------
    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("parameterId")
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;
    //----------------------

    @Column(name = "value")
    private String value;

    public ProductParameter() {
    }

    public ProductParameter(ProductParameterId productParameterId, String value) {
        this.productParameterId = productParameterId;
        this.value = value;
    }

    public ProductParameterId getProductParameterId() {
        return productParameterId;
    }

    public void setProductParameterId(ProductParameterId productParameterId) {
        this.productParameterId = productParameterId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//---------TODO------------
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CardAccessId that = (CardAccessId) o;
//
//        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
//        return doorId != null ? doorId.equals(that.doorId) : that.doorId == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = cardNumber != null ? cardNumber.hashCode() : 0;
//        result = 31 * result + (doorId != null ? doorId.hashCode() : 0);
//        return result;
//    }
}
