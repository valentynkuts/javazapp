package pl.edu.pjwstk.jaz.admin.category.add;

import pl.edu.pjwstk.jaz.product.jpa.Category;
import pl.edu.pjwstk.jaz.product.jpa.Section;

public class AddCategoryRequest {
    private Long id;
    private String name;
    private Long sectionId;

    public AddCategoryRequest() {
    }

    public AddCategoryRequest(Long id, String name, Long sectionId) {
        this.id = id;
        this.name = name;
        this.sectionId = sectionId;
    }

        public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
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

}
