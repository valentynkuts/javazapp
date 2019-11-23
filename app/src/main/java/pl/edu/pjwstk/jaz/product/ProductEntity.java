package pl.edu.pjwstk.jaz.product;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_product;

    private String title;
    private String description;
    private float price;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Collection<ProductParametrValEntity> parametrs;

    @OneToMany
    @JoinColumn(name = "photo_id")
    private Collection<PhotoOfProductEntity> photos;






    //category_id  BIGINT NOT NULL,
    //creator_id  BIGINT NOT NULL,
}
