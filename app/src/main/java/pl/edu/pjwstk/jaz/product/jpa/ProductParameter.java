package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "product_parameter")
public class ProductParameter implements Serializable {
    //@EmbeddedId
    //private ProductParameterId productParameterId;

    //---------TODO------------
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@MapsId("parameterId")
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;
    //----------------------

    @Column(name = "value")
    private String value;

    public ProductParameter() {
    }

    public ProductParameter(Product product, Parameter parameter, String value) {//TODO
        this.product = product;
        this.parameter = parameter;
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

//    public ProductParameter(ProductParameterId productParameterId, String value) {
//        this.productParameterId = productParameterId;
//        this.value = value;
//    }
//
//    public ProductParameterId getProductParameterId() {
//        return productParameterId;
//    }
//
//    public void setProductParameterId(ProductParameterId productParameterId) {
//        this.productParameterId = productParameterId;
//    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
