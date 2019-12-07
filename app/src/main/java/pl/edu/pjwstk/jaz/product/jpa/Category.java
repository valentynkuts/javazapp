package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "section_id")
    private Section section;

    public Category() {
       // this.section = new Section();
    }

    public Category(Long id, String name, Section section) {
        this.id = id;
        this.name = name;
        this.section = section;
//        this.section = new Section();
//        this.section.setId(section.getId());
//        this.section.setName(section.getName());
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

}
