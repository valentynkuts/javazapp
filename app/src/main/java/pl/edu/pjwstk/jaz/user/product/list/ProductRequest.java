package pl.edu.pjwstk.jaz.user.product.list;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import java.util.Collection;
import java.util.List;

public class ProductRequest {
    private  Long id;
    private String title;
    private String description;
    private float price;
    private Category category;
    private Long sectionId;
    //private Long categoryId;

    private Long ownerId;
    private List<Photo> photos ;
    private List<ProductParameter> parameters ;

    public ProductRequest() {
    }

    public ProductRequest(Long id, String title, String description, float price, Category category,
                          Long sectionId, Long ownerId, List<Photo> photos, List<ProductParameter> parameters) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.sectionId = sectionId;
        this.ownerId = ownerId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<ProductParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<ProductParameter> parameters) {
        this.parameters = parameters;
    }
}
