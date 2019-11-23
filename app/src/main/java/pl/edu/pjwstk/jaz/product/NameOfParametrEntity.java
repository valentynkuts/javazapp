package pl.edu.pjwstk.jaz.product;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "parametr_name")
public class NameOfParametrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_parametr;

    private String name_key;

    @OneToMany
    @JoinColumn(name = "parametr_id")
    private Collection<ProductParametrValEntity> parametrsVal;

//    @OneToOne  //??
//    @JoinColumn(name = "parametr_id")
//    private ProductParametrValEntity parametrsVal;

    public NameOfParametrEntity() {
    }

    public NameOfParametrEntity(String name_key) {
        this.name_key = name_key;
    }

    public Long getId_parametr() {
        return id_parametr;
    }

    public void setId_parametr(Long id_parametr) {
        this.id_parametr = id_parametr;
    }

    public String getName_key() {
        return name_key;
    }

    public void setName_key(String name_key) {
        this.name_key = name_key;
    }
}
