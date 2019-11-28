package pl.edu.pjwstk.jaz.admin.section;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Collection;

@Named
@RequestScoped
public class SectionRequest {
    private Long id;
    private String name;
    private Collection<Category> categories;
    //==============??
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
    public SectionRequest(Long id, String name, Collection<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section toSection() {
        return new Section(name);
    }
}
