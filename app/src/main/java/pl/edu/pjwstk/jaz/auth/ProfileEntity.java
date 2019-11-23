package pl.edu.pjwstk.jaz.auth;

import pl.edu.pjwstk.jaz.product.ProductEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
    private String birthday;
    private String role;

    @OneToMany
    @JoinColumn(name = "creator_id")
    private Collection<ProductEntity> products;

    public ProfileEntity() {
    }

    public ProfileEntity(String name, String surname, String password, String email,
                         String username, String birthday,String role) {

        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.username = username;
        this.birthday = birthday;
        this.role = role;
    }

    public ProfileEntity(String name, String surname, String password, String email, String username,
                         String birthday, String role, Collection<ProductEntity> products) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.username = username;
        this.birthday = birthday;
        this.role = role;
        this.products = products;
    }

    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                " name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", username ='" + username + '\'' +
                ", password ='" + password + '\'' +
                ", email ='" + email + '\'' +
                ", birthday ='" + birthday + '\'' +
                '}';
    }

}
