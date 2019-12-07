package pl.edu.pjwstk.jaz.admin.category.add;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.category.edit.EditCategoryRequest;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.admin.section.edit.EditSectionRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddCategoryController_Old {
//    @Inject
//    private CategoryRepository categoryRepository;
//
//    @Inject
//    private SectionRepository sectionRepository;
//
//    @Inject
//    private ParamRetriever paramRetriever;
//
//    // @Inject
//    private AddCategoryRequest addCategoryRequest;
//
//    public AddCategoryRequest getAddRequest() {
//        if (addCategoryRequest == null) {
//            addCategoryRequest = createAddCategoryRequest();
//            System.out.println("addCategoryRequest OK");
//            System.out.println("---- addCategoryRequest.section.id = " + addCategoryRequest.getSectionId() + "----------"); //TODO
//            var section = sectionRepository.findSectionById(addCategoryRequest.getSectionId()).orElseThrow();//TODO
//
//        }
//       // System.out.println(addCategoryRequest);
//        return addCategoryRequest;
//    }
//
//    private AddCategoryRequest createAddCategoryRequest() {
//        if (paramRetriever.contains("sectionId")) {
//            var sectionId = paramRetriever.getLong("sectionId");
//            var section = sectionRepository.findSectionById(sectionId).orElseThrow();  //TODO
//            System.out.println("---createAddCategoryRequest------ section.id = " + section.getId()+ "----------");//TODO
//            return new AddCategoryRequest(section);
//        }
//        return new AddCategoryRequest();
//    }
//
////    private EditSectionRequest createEditSectionRequest() {
////        if (paramRetriever.contains("sectionId")) {
////            var sectionId = paramRetriever.getLong("sectionId");
////            var section = sectionRepository.findSectionById(sectionId).orElseThrow();  //TODO
////            return new EditSectionRequest(section);
////        }
////        return new EditSectionRequest();
////    }
//
//    public String save() {
//        System.out.println(addCategoryRequest);
//        var category = addCategoryRequest.toCategory();
//        categoryRepository.save(category);
//
//        return "/admin/category/categoryList.xhtml?faces-redirect=true";
//    }
//
//    public String show() {
//        System.out.println(addCategoryRequest.getName());//TODO
//        System.out.println("--show-------- addCategoryRequest.section.id = " + addCategoryRequest.getSection().getId() + "----------");
//
//        return "/admin/category/categoryList.xhtml?faces-redirect=true";
//    }

}
