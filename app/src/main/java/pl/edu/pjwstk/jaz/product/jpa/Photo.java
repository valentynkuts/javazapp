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
