package pl.edu.pjwstk.jaz.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequest {

    private String password;
    private String username;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isAttributesSet() {
        if (password != null && username != null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                ", username ='" + username + '\'' +
                ", password ='" + password + '\'' +
                '}';
    }
}
