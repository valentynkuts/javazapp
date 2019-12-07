package pl.edu.pjwstk.jaz.admin.section.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditSectionController {
    @Inject
    private SectionRepository sectionRepository;

    @Inject
    private ParamRetriever paramRetriever;

    private EditSectionRequest editSectionRequest;

    public EditSectionRequest getEditRequest() {
        if (editSectionRequest == null) {
            editSectionRequest = createEditSectionRequest();
        }
        return editSectionRequest;
    }

    private EditSectionRequest createEditSectionRequest() {
        if (paramRetriever.contains("sectionId")) {
            var sectionId = paramRetriever.getLong("sectionId");
            var section = sectionRepository.findSectionById(sectionId).orElseThrow();  //TODO
            return new EditSectionRequest(section);
        }
        return new EditSectionRequest();
    }

    public String save() {
        var section = editSectionRequest.toSection();
        sectionRepository.save(section);

        return "/admin/section/sectionList.xhtml?faces-redirect=true";
    }

}
