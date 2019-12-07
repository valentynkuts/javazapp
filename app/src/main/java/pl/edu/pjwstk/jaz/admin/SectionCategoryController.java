package pl.edu.pjwstk.jaz.admin;

import pl.edu.pjwstk.jaz.admin.category.CategoryRequest;
import pl.edu.pjwstk.jaz.admin.section.SectionRequest;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class SectionCategoryController {
//    @Inject
//    private SectionRequest sectionRequest;
//    @Inject
//    private CategoryRequest categoryRequest;
//    @Inject
//    private SectionCategoryService scs;
//
//    public void addSection(){
//        scs.addSection(sectionRequest.getName());
//    }
//
//    public void addCategory(){
//        scs.addCategory(categoryRequest.getName());
//    }
//
//    public List sectionList(){
//
//        ArrayList<Object> sectionEntityList = new ArrayList<Object>(scs.getSectionList());
//        ArrayList<SectionRequest> sectionsList = new ArrayList<>();
//        //scs.getSectionList().stream().forEach();
//        for(int i = 0;i<sectionEntityList.size();i++){
//            Section s = (Section) sectionEntityList.get(i);
//            System.out.println(sectionEntityList.get(i));
//            System.out.println(s.getId());
//        }
//          return scs.getSectionList();
//
//
//    }


}
