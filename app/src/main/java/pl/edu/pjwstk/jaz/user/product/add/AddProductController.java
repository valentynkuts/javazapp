package pl.edu.pjwstk.jaz.user.product.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Product;
import pl.edu.pjwstk.jaz.user.product.add.parameter.AddParameterRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AddProductController {
    @Inject
    private ProductService productService;

    @Inject
    private ParamRetriever paramRetriever;

    private AddProductRequest addProductRequest;
    //private AddPhotoRequest addPhotoRequest;
   // private AddParameterRequest addParameterRequest;


    public AddProductRequest getAddRequest() {
        if (addProductRequest == null) {
            addProductRequest = new AddProductRequest();
        }
        return addProductRequest;
    }
//    public AddPhotoRequest getAddPhotoRequest() {
//        if (addPhotoRequest == null) {
//            addPhotoRequest = new AddPhotoRequest();
//        }
//        return addPhotoRequest;
//    }

//    public AddParameterRequest getAddParameterRequest() {
//        if (addParameterRequest == null) {
//            addParameterRequest = new AddParameterRequest();
//        }
//        return addParameterRequest;
//    }

    public List<Category> getCategoryListBySectionId() {
        if (getAddRequest().getSectionId() != null) {
            Long sectionId = getAddRequest().getSectionId();
            return productService.findCategoryBySectionId(sectionId);
        }
        return productService.findCategoryBySectionId(3l);
    }

    public Long getOwnerId() {
        Long ownerId = paramRetriever.getLongUserId("id");
        addProductRequest.setOwnerId(ownerId);
        return addProductRequest.getOwnerId();
    }

    public List<Product> getProductListByOwnerId() {
        Long ownerId = getOwnerId();
        return productService.getProductListByOwnerId(ownerId);
        //return productService.getProductListByOwnerId(47l);

    }

    public String save() {
        System.out.println("OwnerId: "+getOwnerId());
        System.out.println("SectionId: "+addProductRequest.getSectionId());
        System.out.println("CategoryId: "+addProductRequest.getCategoryId());
        System.out.println("Title: "+addProductRequest.getTitle());
        System.out.println("Description: "+addProductRequest.getDescription());
        System.out.println("Price: "+addProductRequest.getPrice());
//        System.out.println("Name parameter: "+addParameterRequest.getName());
//        System.out.println("Value of parameter: "+addParameterRequest.getValue());
//        System.out.println("Photo link: "+addPhotoRequest.getLink());
//        System.out.println("Sequence of photo: "+addPhotoRequest.getSequence());
//        var section = categoryService.findSectionById(addCategoryRequest.getSectionId()).orElseThrow();
//        categoryService.save(new Category(addCategoryRequest.getId(), addCategoryRequest.getName(),section));

        var category = productService.findCategoryById(addProductRequest.getCategoryId()).orElseThrow();
        productService.save(new Product(addProductRequest.getTitle(),addProductRequest.getDescription(),
                addProductRequest.getPrice(),getOwnerId(),category));

        return "/user/addProduct.xhtml?faces-redirect=true";
    }

    public String  saveParameter(){
        return "/user/addProduct.xhtml?faces-redirect=true";

    }

    public String  savePhotoLink(){

        return "/user/addProduct.xhtml?faces-redirect=true";

    }



}
