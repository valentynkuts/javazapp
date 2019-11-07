package pl.edu.pjwstk.jaz.login;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if ((req.getRequestURI().contains("index.xhtml") || req.getRequestURI().equals(req.getContextPath() + "/"))
                && req.getSession().getAttribute("name") == null) {
            res.sendRedirect("login.xhtml");
        } else if (req.getRequestURI().matches(req.getContextPath() + "/" + "protected.xhtml")) {
            res.sendRedirect("login.xhtml");
        } else {
            chain.doFilter(req, res);
        }
    }

}
////1111Qqqq