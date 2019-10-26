package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.ProfileRepository;
import pl.edu.pjwstk.jaz.login.LoginRequest;
import pl.edu.pjwstk.jaz.login.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

    //private HashMap<String, String> data = new HashMap<String, String>();


    public String info() {
        return user.toString();
    }
    @Transactional
    public void registration(){

        if(user.isAttributesSet()){

//            List resultlist  = pr.selectListWithUsername(user.getUsername());
//            System.out.println(resultlist.get(0));

            //ProfileEntity p = pr.selectProfileEntityWhereId1();
            //System.out.println(p);
            ProfileEntity pe = null;
            try {
                 pe = pr.selectSingleResWithUsername(user.getUsername());
                System.out.println(pe);
            } catch (NoResultException nre){

            }

            if(pe == null){
                String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
            }


//            if (loginRequest.getUsername().equals(data.get("username"))) {
//
//                FacesContext facesContext = FacesContext.getCurrentInstance();
//                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//                session.setAttribute("name", loginRequest.getName());
//                session.setAttribute("surname", loginRequest.getSurname());
//                ////session.getSessionMaxInactiveInterval(30); // 30 seconds //????
//
//                //System.out.println(session.getAttribute("name"));
//
//                facesContext.getExternalContext().redirect("index.xhtml");
//
//            }
            //pr.addTest();

        }

    }
    public String welcomUserName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        return session.getAttribute("name") + "  " + session.getAttribute("surname");

    }

}
