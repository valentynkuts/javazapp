package pl.edu.pjwstk.jaz.webapp;


import org.springframework.security.crypto.bcrypt.BCrypt;
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

public class AdminController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    private ProfileRepository pr;

    private boolean isAdminExist = false;

    public boolean getIsAdminExist() {
        return isAdminExist;
    }

    public void setIsAdminExist(boolean adminExist) {
        isAdminExist = adminExist;
    }

    public String info() {
        return "Admin name or password are wrong";
    }

    public void login() throws IOException {

        if (loginRequest.isAttributesSet()) {
            ProfileEntity pe = null;
            try {
                pe = pr.selectSingleResWithUsername(loginRequest.getUsername().trim());
                String passw = loginRequest.getPassword().trim();

                if (BCrypt.checkpw(passw, pe.getPassword())) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                    session.setAttribute("admin", pe.getName());
                    facesContext.getExternalContext().redirect("protected.xhtml");

                }

            } catch (NoResultException nre) {
                System.out.println("Admin does not exist");
                setIsAdminExist(true);
            } catch (IllegalArgumentException iae) {
                System.out.println("Admin does not exist");
                setIsAdminExist(true);
            }
        }
    }

    public String welcomAdminName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        return (String) session.getAttribute("admin");

    }

}

