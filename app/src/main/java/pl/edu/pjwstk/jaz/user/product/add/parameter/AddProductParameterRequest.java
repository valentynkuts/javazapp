package pl.edu.pjwstk.jaz.user.product.add.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AddProductParameterRequest {
    private Long productId;
    private Long parameterId;
    private String value;

    public AddProductParameterRequest() {
    }

    public AddProductParameterRequest(Long productId, Long parameterId, String value) {
        this.productId = productId;
        this.parameterId = parameterId;
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
