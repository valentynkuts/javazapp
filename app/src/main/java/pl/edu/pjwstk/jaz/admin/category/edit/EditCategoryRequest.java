package pl.edu.pjwstk.jaz.admin.category.edit;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

public class EditCategoryRequest {
    private Long id;
    private String name;
    private Section section;

    public EditCategoryRequest() {
    }

    public EditCategoryRequest(Long id, String name, Section section) {
        this.id = id;
        this.name = name;
        this.section = section;
    }

    public EditCategoryRequest(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.section = category.getSection();
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Category toCategory() {
        return new Category(id, name, section);
    }
}
