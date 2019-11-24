package pl.edu.pjwstk.jaz.admin;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionRequest {
    private Long id;
    private String name;
    //==============
    private String selectedItem;

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
//==================
    public SectionRequest() {
    }

    public SectionRequest(String name) {
        this.name = name;
    }

    public SectionRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
