package pl.edu.pjwstk.jaz.admin.section;

import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class SectionController {
//    @Inject
//    private SectionRequest sectionRequest;
//    @Inject
//    private SectionService ss;
//    @Inject
//    private SectionRepository sectionRepository;
//
////    public void addSection(){
////        ss.addSection(sectionRequest.getName());
////    }
//
////    public String save() {
////        var door = sectionRequest.toSection();
////        ss.addSection(door);
////
////        return "/samples/doorlist.xhtml?faces-redirect=true";
////    }
//    public void addSection() {
//        var section = sectionRequest.toSection();
//        ss.addSection(section);
//    }
//
//    public void editSection() {
//        var section = sectionRequest.toSection();
//        ss.addSection(section);
//    }
//
//    public List sectionList(){
//
////        ArrayList<Object> sectionEntityList = new ArrayList<Object>(scs.getSectionList());
////        ArrayList<SectionRequest> sectionsList = new ArrayList<>();
////        //scs.getSectionList().stream().forEach();
////        for(int i = 0;i<sectionEntityList.size();i++){
////            Section s = (Section) sectionEntityList.get(i);
////            System.out.println(sectionEntityList.get(i));
////            System.out.println(s.getId_section());
////        }
//        return ss.getSectionList();
//    }
//
//    public List<Section> getSectionList() {
//        return sectionRepository.findAll();
//    }

}
