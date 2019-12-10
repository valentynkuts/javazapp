package pl.edu.pjwstk.jaz.user.product.add;

public class AddPhotoRequest {
    private Long id;
    private String link;
    private int sequence;
    private Long product_id;

    public AddPhotoRequest() {
    }

    public AddPhotoRequest(Long id, String link, int sequence, Long product_id) {
        this.id = id;
        this.link = link;
        this.sequence = sequence;
        this.product_id = product_id;
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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
