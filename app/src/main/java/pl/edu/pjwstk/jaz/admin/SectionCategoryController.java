package pl.edu.pjwstk.jaz.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionCategoryController {
    @Inject
    private SectionRequest sectionRequest;
    @Inject
    private CategoryRequest categoryRequest;
    @Inject
    private SectionCategoryService scs;

    public void add(){
        scs.addSection(sectionRequest.getName());
        //scs.addCategory(categoryRequest.getName());


    }

    public void sectionList(){

    }




}
