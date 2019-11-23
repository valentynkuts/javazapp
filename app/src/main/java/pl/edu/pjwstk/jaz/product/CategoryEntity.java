package pl.edu.pjwstk.jaz.product;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_category;

    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Collection<ProductEntity> products;

    public CategoryEntity() {
    }

    public CategoryEntity(String name, Collection<ProductEntity> products) {
        this.name = name;
        this.products = products;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }

}
