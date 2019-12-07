package pl.edu.pjwstk.jaz.login;

import javax.faces.application.ResourceHandler;
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

        /*if ((req.getRequestURI().contains("index.xhtml") || req.getRequestURI().equals(req.getContextPath() + "/"))
                && req.getSession().getAttribute("name") == null) {
            res.sendRedirect("login.xhtml");
        } else if (req.getRequestURI().matches(req.getContextPath() + "/admin/protected.xhtml")
                && req.getSession().getAttribute("admin") == null) {
            res.sendRedirect("login.xhtml");
        } else {
            chain.doFilter(req, res);
        }*/
        //--------------------

        if (isResourceReq(req) || isSiteAllowed(req) || isUserLogged(req)) {

//            System.out.println("isResourceReq(req): " + isResourceReq(req));  ////TODO
//            System.out.println("isSiteAllowed(req): " + isSiteAllowed(req));  ////TODO
//            System.out.println("isUserLogged(req): " + isUserLogged(req));  ////TODO
            ////////if (isAdminSite(req) && isAdminLogged(req))

            chain.doFilter(req, res);
        } else if (isResourceReq(req) || isAdminSite(req) || isAdminLogged(req)) {

//            System.out.println("isResourceReq(req): " + isResourceReq(req));  ////TODO
//            System.out.println("isSiteAllowed(req): " + isSiteAllowed(req));  ////TODO
//            System.out.println("isUserLogged(req): " + isUserLogged(req));  ////TODO

            chain.doFilter(req, res);
        } else {
            res.sendRedirect(getServletContext().getContextPath() + "/login.xhtml");
        }
        //----------
    }

    private boolean isResourceReq(HttpServletRequest req) {

        //System.out.println("1-req.getRequestURI(): " + req.getRequestURI()); ////TODO
        //System.out.println("1-req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + /: " + req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/"); ////TODO

        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isSiteAllowed(HttpServletRequest req) {

       // System.out.println("2-req.getContextPath(): " + req.getContextPath()); ////TODO

        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/registration.xhtml");
    }

    private boolean isUserLogged(HttpServletRequest req) {
        var session = req.getSession(false);

       // System.out.println("3-session: " + session);  ////TODO

        return session != null && session.getAttribute("username") != null;
    }

    private boolean isAdminSite(HttpServletRequest req) {

        //System.out.println("4-req.getContextPath(): " + req.getContextPath()); ////TODO

        return req.getRequestURI().equals(req.getContextPath() + "/admin/protected.xhtml") ||
                req.getRequestURI().contains("admin"); //TODO
    }

    private boolean isAdminLogged(HttpServletRequest req) {
        var session = req.getSession(false);

       // System.out.println("5-session: " + session);  ////TODO

        return session != null && session.getAttribute("admin") != null;
    }

}
