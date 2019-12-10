package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.product.jpa.ProductParameter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class AddProductRequest {

    private  Long id;
    private String title;
    private String description;
    private float price;
    //private Category category;
    private Long sectionId;
    private Long categoryId;

    private Long ownerId;
//    private List<Photo> photos ;
//    private Collection<ProductParameter> parameters ;
    private Photo photo ;
    private ProductParameter parameter;

    public AddProductRequest() {
    }

    public AddProductRequest(Long id, String title, String description, float price, Long sectionId,
                             Long categoryId, Long ownerId, Photo photo, ProductParameter parameter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.sectionId = sectionId;
        this.categoryId = categoryId;
        this.ownerId = ownerId;
        this.photo = photo;
        this.parameter = parameter;
    }

    //    public AddProductRequest(Long id, String title, String description,
//                             float price, Category category, Long ownerId,
//                             List<Photo> photos, Collection<ProductParameter> parameters) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.category = category;
//        this.ownerId = ownerId;
//        this.photos = photos;
//        this.parameters = parameters;
//    }

//    public AddProductRequest(Long id, String title, String description, float price, Long sectionId, Long categoryId, Long ownerId, List<Photo> photos, Collection<ProductParameter> parameters) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.sectionId = sectionId;
//        this.categoryId = categoryId;
//        this.ownerId = ownerId;
//        this.photos = photos;
//        this.parameters = parameters;
//    }

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

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public ProductParameter getParameter() {
        return parameter;
    }

    public void setParameter(ProductParameter parameter) {
        this.parameter = parameter;
    }

    //    public List<Photo> getPhotos() {
//        return photos;
//    }
//
//    public void setPhotos(List<Photo> photos) {
//        this.photos = photos;
//    }
//
//    public Collection<ProductParameter> getParameters() {
//        return parameters;
//    }
//
//    public void setParameters(Collection<ProductParameter> parameters) {
//        this.parameters = parameters;
//    }
}
