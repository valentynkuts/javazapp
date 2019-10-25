package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Named
@RequestScoped

public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    private HashMap<String, String> data = new HashMap<String, String>();


    public String info() {
        return loginRequest.toString();
    }

    public void login() throws IOException {

//        data.put("name", "Test");
//        data.put("surname", "surTest");
//        data.put("password", "1234qQQQ");
//        data.put("username", "qqqq1234");
//        data.put("email", "test@gmail.com");
//        data.put("birthday", "22/02/2002");

        data.put("name", loginRequest.getName());
        data.put("surname", loginRequest.getSurname());
        data.put("password", loginRequest.getPassword());
        data.put("username", loginRequest.getUsername());
        data.put("email", loginRequest.getEmail());
        data.put("birthday", loginRequest.getBirthday());

        String username = data.get("username");

        if(loginRequest.isAttributesSet()){
            if (loginRequest.getUsername().equals(data.get("username"))) {

                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("name", loginRequest.getName());
                session.setAttribute("surname", loginRequest.getSurname());
                ////session.getSessionMaxInactiveInterval(30); // 30 seconds //????

                //System.out.println(session.getAttribute("name"));

                facesContext.getExternalContext().redirect("index.xhtml");

            }

        }

    }
    public String welcomUserName() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        return session.getAttribute("name") + "  " + session.getAttribute("surname");

    }

}

