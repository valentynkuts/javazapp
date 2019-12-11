package pl.edu.pjwstk.jaz.user.product.add.parameter;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.product.jpa.Parameter;
import pl.edu.pjwstk.jaz.product.jpa.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AddParameterController {
    @Inject
    private ParameterService parameterService;

    @Inject
    private ParamRetriever paramRetriever;

    private AddParameterRequest addParameterRequest;

    public AddParameterRequest getAddParameterRequest() {
        if (addParameterRequest == null) {
            addParameterRequest = new AddParameterRequest();
        }
        return addParameterRequest;
    }

    public Long getOwnerId() {
        Long ownerid = paramRetriever.getLongUserId("id");
        return ownerid;
    }
    public List<Product> getProductListByOwnerId(){
        Long ownerId = getOwnerId();
        return parameterService.getProductListByOwnerId(ownerId);

    }


    public String saveParameter(){
        parameterService.saveParameter(new Parameter(addParameterRequest.getName()));
        return "/user/parameter/addParameter.xhtml?faces-redirect=true";
    }

    public String save(){
        return "/user/parameter/addParameter.xhtml?faces-redirect=true";
    }
}
