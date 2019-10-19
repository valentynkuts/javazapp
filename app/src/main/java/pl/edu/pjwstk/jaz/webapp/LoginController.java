package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
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
public class LoginController extends HttpServlet {
    @Inject
    private LoginRequest loginRequest;

    public String info() {
        return loginRequest.msg();
    }

    public void login() {
//        if (loginRequest.getEmail() == "qqqq") {
//            HttpSession session = request.getSession(true); // reuse existing
//            // session if exist
//            // or create one
//            session.setAttribute("user", un);
//            session.setMaxInactiveInterval(30); // 30 seconds
//            response.sendRedirect("home.jsp");
//        }
    }


    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res) throws ServletException, IOException {
        //response.setContentType("text/html");
        var respWriter = res.getWriter();
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        String username = req.getParameter("username");

        if (name.equals("Test") && pwd.equals("Test1234")) {

            HttpSession session = req.getSession(true); // reuse existing
            // session if exist
            // or create one
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30); // 30 seconds
            res.sendRedirect("index.xhtml");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("login.xhtml");
            respWriter.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, res);
        } // TODO Auto-generated method stub
    }
}

