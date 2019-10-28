package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.ProfileRepository;
import pl.edu.pjwstk.jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped

public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    private ProfileRepository pr;

    private boolean isUserExist = false;

    public boolean getIsUserExist() {
        return isUserExist;
    }

    public void setIsUserExist(boolean userExist) {
        isUserExist = userExist;
    }

    public String info() {
        return "Username or password are wrong";
    }

    public void login() throws IOException {

        if (loginRequest.isAttributesSet()) {
            ProfileEntity pe = null;
            try {
                pe = pr.selectSingleResWithUsername(loginRequest.getUsername().trim());
                String passw = loginRequest.getPassword().trim();
                //if (BCrypt.checkpw(passw, pe.getPassword())) //BCrypt.checkpw(candidate_password, stored_hash) TODO
                if (pe.getPassword().equals(passw)) {

                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                    session.setAttribute("name", pe.getName());
                    session.setAttribute("surname", pe.getSurname());
                    facesContext.getExternalContext().redirect("index.xhtml");

                } else {
                    setIsUserExist(true);
                }

            } catch (NoResultException nre) {
                System.out.println("User does not exist");
                setIsUserExist(true);
            }
        }
    }

    public String welcomUserName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        return session.getAttribute("name") + "  " + session.getAttribute("surname");

    }

}

