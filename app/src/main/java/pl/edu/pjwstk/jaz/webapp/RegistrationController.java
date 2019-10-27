package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.ProfileRepository;
import pl.edu.pjwstk.jaz.login.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;

//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
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

//    public String info() {
//        return user.toString();
//    }
public String info() {
    return "Username exists try again";
}

    public void registration() throws IOException {

        if(user.isAttributesSet()){

            ProfileEntity pe = null;
            try {
                pe = pr.selectSingleResWithUsername(user.getUsername().trim());
                //System.out.println("Username exists ");
                //System.out.println(pe);
            } catch (NoResultException nre){
                System.out.println("Username does not exist");
            }

            if(pe == null) {
                //setIsUserExist(false);
                String plain_password = user.getPassword().trim();
                //String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
                String name = user.getName().trim();
                String suname = user.getSurname().trim();

                pr.insert(name, suname, plain_password,
                        user.getEmail().trim(), user.getUsername().trim(), user.getBirthday().trim());


                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("name", name);
                session.setAttribute("surname", suname);

                //System.out.println(session.getAttribute("name"));

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
