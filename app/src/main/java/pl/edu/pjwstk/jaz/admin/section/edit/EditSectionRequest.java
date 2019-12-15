package pl.edu.pjwstk.jaz.admin.section.edit;

import pl.edu.pjwstk.jaz.product.jpa.Section;

public class EditSectionRequest {

    private Long id;
    private String name;

    public EditSectionRequest() {
    }

    public EditSectionRequest(Section section) {
        this.id = section.getId();
        this.name = section.getName();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section toSection() {
        return new Section(id, name);
    }

}
