package pl.edu.pjwstk.jaz.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequest {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String username;
    private String birthday;

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

    public boolean isAttributesSet() {
        if (name != null && surname != null && password != null && username != null
                && email != null && birthday != null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                " name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", username ='" + username + '\'' +
                ", password ='" + password + '\'' +
                ", email ='" + email + '\'' +
                ", birthday ='" + birthday + '\'' +
                '}';
    }
}
