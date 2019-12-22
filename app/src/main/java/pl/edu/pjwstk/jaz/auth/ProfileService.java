package pl.edu.pjwstk.jaz.auth;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@ApplicationScoped
public class ProfileService {
    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private HttpServletRequest request;

    public void logout() {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
/*
    private final DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    public boolean logIn(String username, String password) {
        if (isUsernameAndPasswordCorrect(username, password)) {
            var session = request.getSession(true);
            session.setAttribute("username", username);

            return true;
        }
        return false;
    }

    private boolean isUsernameAndPasswordCorrect(String username, String password) {
        var userOptional = profileRepository.findUserByUsername(username);
        if (userOptional.isEmpty()) {
            return false;
        }
        var user = userOptional.get();
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    public boolean doesUserExist(String username) {
        //noinspection SimplifyOptionalCallChains // just for learning
        return !profileRepository.findUserByUsername(username).isEmpty();
    }

    public void addUser(String firstName, String lastName, String username, String password, String email, String birthday) {
        var user = new User(firstName, lastName, username, password, email, parseDate(birthday));
        profileRepository.addUser(user);
    }

    private LocalDate parseDate(String dateAsText) {
        try {
            var parsedDate = dateFormat.parse(dateAsText);

            return parsedDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void addTest() {
        var user = new User("Admin", "Admin","admin", "admin",
                "admin@admin.pl", LocalDate.parse("2007-12-03"));
        profileRepository.addUser(user);
    }
    */

}