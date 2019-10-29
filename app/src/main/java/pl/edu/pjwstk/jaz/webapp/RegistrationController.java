package pl.edu.pjwstk.jaz.webapp;

import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.ProfileRepository;
import pl.edu.pjwstk.jaz.login.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped

public class RegistrationController {

    @Inject
    private User user;
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
        return "Username exists try again";
    }

    public void registration() throws IOException {

        if (user.isAttributesSet()) {

            ProfileEntity pe = null;
            try {
                pe = pr.selectSingleResWithUsername(user.getUsername().trim());

            } catch (NoResultException nre) {
                System.out.println("Username does not exist");
            }

            if (pe == null) {
                String plain_password = user.getPassword().trim();
                String name = user.getName().trim();
                String suname = user.getSurname().trim();
                String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
                //pw_hash -  instead of -  plain_password
                pr.insert(name, suname, pw_hash,
                        user.getEmail().trim(), user.getUsername().trim(), user.getBirthday().trim());

                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("name", name);
                session.setAttribute("surname", suname);
                facesContext.getExternalContext().redirect("index.xhtml");

            } else {
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
