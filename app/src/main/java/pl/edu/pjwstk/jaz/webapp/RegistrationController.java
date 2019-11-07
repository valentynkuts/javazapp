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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                //----Date
                String bithday = user.getBirthday().trim();
                System.out.println(bithday);

//                String dateInString = bithday;
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                LocalDate dateTime = LocalDate.parse(dateInString, formatter);
//                System.out.println(dateTime);

//                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                Date date = dateFormat.parse(bithday);
//                System.out.println(dateFormat.format(date));


                String input = bithday; //"Thu Jun 18 20:56:02 EDT 2009";  Mon Jul 07 02:00:00 CEST 1997
                SimpleDateFormat parser = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date date = parser.parse(input);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(date);
                user.setBirthday(formattedDate);
                System.out.println(user.getBirthday());
                System.out.println(formattedDate);
//-----------
//                String pattern = "dd/MM/yyyy";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//
//                String date1 = simpleDateFormat.format(new Date());
//                System.out.println(date1);
                //--------

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
////1111Qqqq
//Mon Jul 07 02:00:00 CEST 1997