package pl.edu.pjwstk.jaz.login;

import pl.edu.pjwstk.jaz.auth.ProfileService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutController {
    @Inject
    private ProfileService profileService;

    public String logout() {
        profileService.logout();

        return "login.xhtml?faces-redirect=true";
    }
}
