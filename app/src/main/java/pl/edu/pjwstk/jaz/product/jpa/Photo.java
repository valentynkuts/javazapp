package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "link")
    private String link;

    @Column(name = "sequence")
    private int sequence;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
 // ok //add auction

    public Photo() {
    }

    public Photo(String link) {
        this.link = link;
    }

    public Photo(String link, int sequence, Product product) {
        this.link = link;
        this.sequence = sequence;
        this.product = product;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
