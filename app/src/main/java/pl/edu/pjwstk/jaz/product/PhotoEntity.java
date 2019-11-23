package pl.edu.pjwstk.jaz.product;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_photo;

    private String name;
    private String path;

    public PhotoEntity() {
    }

    public PhotoEntity(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Long getId_photo() {
        return id_photo;
    }

    public void setId_photo(Long id_photo) {
        this.id_photo = id_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
