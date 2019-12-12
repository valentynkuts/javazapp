package pl.edu.pjwstk.jaz.user.product.add.parameter;

public class AddParameterRequest {
    private  Long id;
    private String name;


    public AddParameterRequest() {
    }

    public AddParameterRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //    public AddParameterRequest(Long id, String name, Long productId) {
//        this.id = id;
//        this.name = name;
//        this.productId = productId;
//    }
//    public AddParameterRequest(Long id, String name, String value) {
//        this.id = id;
//        this.name = name;
//        this.value = value;
//    }

//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
}
