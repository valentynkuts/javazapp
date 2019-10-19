package pl.edu.pjwstk.jaz.login;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

//        if (req.getSession().getAttribute("username") == null) {
//            //res.sendRedirect("login.xhtml");
//        } else {
//            chain.doFilter(req, res);
//        }

//        HttpSession session = req.getSession();
//        if (session != null) {
//            String username = (String) session.getAttribute("username");
//            if(username == null){
//                res.sendRedirect("login.xhtml");
//                //res.sendRedirect("/app/index.xhtml");
//            } else{
//                chain.doFilter(req, res);
//            }
//        }

        if (req.getRequestURI().contains("/index.xhtml") && req.getSession().getAttribute("username") == null) {
            res.sendRedirect("login.xhtml");
        } else {
            chain.doFilter(req, res);
        }


    }
}
