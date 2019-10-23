package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.login.LoginRequest;

import javax.ejb.SessionBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped

public class LoginController {
    @Inject
    private LoginRequest loginRequest;



    public String info() {
        return loginRequest.msg();
    }

    public void login() {
        if(loginRequest.isAttributesSet()){
            if (loginRequest.getUsername().equals("qqqq1234")) {

                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("username", loginRequest.getUsername());
                //session.getSessionMaxInactiveInterval(30); // 30 seconds //????

            }

        }

    }

}

