package pl.edu.pjwstk.jaz.user.product.edit;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import java.util.List;

public class EditProductRequest {
    private  Long id;
    private String title;
    private String description;
    private float price;
    private Category category;

    private Long ownerId;
    private List<Photo> photos ;
    private List<ProductParameter> parameters ;

    private Long photoId;
    private Long parameterId;

    private Long sectionId;
    private Long categoryId;

    private Long version;


    public EditProductRequest() {
    }



    public EditProductRequest(Long id, String title, String description, float price, Category category,
                              Long ownerId, List<Photo> photos, List<ProductParameter> parameters, Long version) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.ownerId = ownerId;
        this.photos = photos;
        this.parameters = parameters;
        this.version = version;

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

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
