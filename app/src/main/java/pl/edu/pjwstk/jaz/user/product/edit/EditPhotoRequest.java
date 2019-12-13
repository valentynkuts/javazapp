package pl.edu.pjwstk.jaz.user.product.edit;

public class EditPhotoRequest {
    private Long id;
    private String link;
    private int sequence;
    private Long productId;

    public EditPhotoRequest() {
    }

    public EditPhotoRequest(Long id, String link, int sequence, Long productId) {
        this.id = id;
        this.link = link;
        this.sequence = sequence;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
