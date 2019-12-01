package pl.edu.pjwstk.jaz.admin.section.list;

import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListSectionController {
    @Inject
    private SectionRepository sectionRepository;

    public List<Section> getSectionList() {
        return sectionRepository.findAll();
    }

}
