package pl.edu.pjwstk.jaz.product;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_section;

    private String name;


    @OneToMany
    @JoinColumn(name = "section_id")
    private Collection<CategoryEntity> categories;

    public SectionEntity() {
    }

    public SectionEntity(String name, Collection<CategoryEntity> categories) {
        this.name = name;
        this.categories = categories;
    }

    public Long getId_section() {
        return id_section;
    }

    public void setId_section(Long id_section) {
        this.id_section = id_section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Collection<CategoryEntity> categories) {
        this.categories = categories;
    }

    public String toString(){
        return name;
    }
}
