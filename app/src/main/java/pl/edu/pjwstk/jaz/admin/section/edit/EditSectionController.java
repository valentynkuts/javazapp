package pl.edu.pjwstk.jaz.admin.section.edit;

import pl.edu.pjwstk.jaz.ParamRetriever;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

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

    public boolean doesSectionExist() {
        try {
            String sectionName = editSectionRequest.getName().trim();
            Section section = sectionRepository.findSectionByName(sectionName);
            if (section.getName().equals(sectionName))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("section does not exist");
            return false;
        }
    }

//    public boolean doesSectionExist() {
//        String sectionName = editSectionRequest.getName().trim();
//        return sectionRepository.findSectionByName(sectionName).isPresent();
//    }

    public String save() {
        if (!doesSectionExist()) {
            var section = editSectionRequest.toSection();
            sectionRepository.save(section);
            return "/admin/section/sectionList.xhtml?faces-redirect=true";
        }
        else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Section exist");
            return "/admin/section/addSection.xhtml?faces-redirect=true";
        }

    }

}
