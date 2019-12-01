package pl.edu.pjwstk.jaz.product.jpa;

import pl.edu.pjwstk.jaz.product.jpa.Category;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public Section(Long id,String name)
    {
        this.id = id;
        this.name = name;
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

    public String toString(){
        return name;
    }
}
