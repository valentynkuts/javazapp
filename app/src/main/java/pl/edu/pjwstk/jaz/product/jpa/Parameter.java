package pl.edu.pjwstk.jaz.product.jpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "parametr_id")
    private Collection<ProductParameter> parametrs;

    public Parameter() {
    }

    public Parameter(String name) {
        this.name = name;
    }

    public Parameter(String name, Collection<ProductParameter> parametrs) {
        this.name = name;
        this.parametrs = parametrs;
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

    public Collection<ProductParameter> getParametrs() {
        return parametrs;
    }

    public void setParametrs(Collection<ProductParameter> parametrs) {
        this.parametrs = parametrs;
    }
}
