package pl.edu.pjwstk.jaz.register;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@RequestScoped

public class User {
    private String name;
    private String surname;
    private String password;
    private String passwordConfirm;
    private String email;
    private String username;
    private String birthday;
    private String role;

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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    public boolean isAttributesSet() {
        if (name != null && surname != null && password != null && passwordConfirm != null && username != null
                && email != null && birthday != null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                " name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", username ='" + username + '\'' +
                ", password ='" + password + '\'' +
                ", passwordConfirm ='" + passwordConfirm + '\'' +
                ", email ='" + email + '\'' +
                ", birthday ='" + birthday + '\'' +
                '}';
    }


    public void validatePasswordCorrect(FacesContext context, UIComponent component, Object value) {

        // Retrieve the value passed to this method
        String confirmPassword = (String) value;

        // Retrieve the temporary value from the password field
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{msg['nomatch']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

}
