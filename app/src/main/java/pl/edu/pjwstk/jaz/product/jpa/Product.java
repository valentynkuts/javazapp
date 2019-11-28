package pl.edu.pjwstk.jaz.product.jpa;

import pl.edu.pjwstk.jaz.auth.ProfileEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Collection<Category> categories; //TODO

    @OneToOne
    @JoinColumn(name = "creator_id")
    private ProfileEntity creator ;

    @OneToMany
    @JoinColumn(name = "product_id")
    @OrderColumn("order")
    private List<PhotoProduct> photos ;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Collection<ProductParameter> parameters ;


    public Product() {
    }

    public Product(String title, String description, float price, Collection<Category> categories, ProfileEntity creator, Collection<PhotoProduct> photos, Collection<ProductParameter> parameters) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.categories = categories;
        this.creator = creator;
        this.photos = photos;
        this.parameters = parameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public ProfileEntity getCreator() {
        return creator;
    }

    public void setCreator(ProfileEntity creator) {
        this.creator = creator;
    }

    public Collection<PhotoProduct> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<PhotoProduct> photos) {
        this.photos = photos;
    }

    public Collection<ProductParameter> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<ProductParameter> parameters) {
        this.parameters = parameters;
    }
}
