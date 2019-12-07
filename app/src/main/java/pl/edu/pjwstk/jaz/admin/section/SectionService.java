package pl.edu.pjwstk.jaz.admin.section;

import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SectionService {
    @Inject
    private SectionRepository sr;

//    public void addSection(String name){
//        sr.addSection(name);
//    }

//    public void addSection(Section section){
//        sr.addSection(section);
//    }
//
//
//    public List getSectionList(){
//        return sr.getSectionList();
//    }
}
