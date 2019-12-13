package pl.edu.pjwstk.jaz.register;

import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.ProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
                //---- Date ----
                String bithday = user.getBirthday().trim();
                System.out.println(bithday);
                SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date date = parser.parse(bithday);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                //String formattedDate = formatter.format(date);
                user.setBirthday(formatter.format(date));
                System.out.println(user.getBirthday());
                //System.out.println(formattedDate);
                //-----------
            } catch (NoResultException nre) {
                System.out.println("Username does not exist");
            } catch (ParseException e) {
                System.out.println("ParseException");
                e.printStackTrace();
            }

            if (pe == null) {
                String plain_password = user.getPassword().trim();
                String name = user.getName().trim();
                String suname = user.getSurname().trim();
                String username = user.getUsername().trim();
                String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
                //pw_hash -  instead of -  plain_password

//               String adminRole = "admin";
//                pr.insert(name, suname, pw_hash,
//                        user.getEmail().trim(), user.getUsername().trim(), user.getBirthday().trim(), adminRole);

                String role = "standard";
                //String role = "admin";
                pr.insert(name, suname, pw_hash,
                        user.getEmail().trim(), user.getUsername().trim(), user.getBirthday().trim(), role);

                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
//                session.setAttribute("name", name);
//                session.setAttribute("surname", suname);

                pe = pr.selectSingleResWithUsername(username);
                session.setAttribute("name", pe.getName());
                session.setAttribute("surname", pe.getSurname());
                session.setAttribute("id", pe.getId());

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
////1111Qqqq