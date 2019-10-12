package pl.edu.pjwstk.jaz.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named // Use @javax.faces.bean.ManagedBean on outdated environments.
@RequestScoped // Use @javax.faces.bean.RequestScoped on outdated environments.
public class Bean {

    private String text;
    private String choice;
    private String result;

    public void submit() {
        result = "Submitted values: " + text + ", " + choice;
        System.out.println(result);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getResult() {
        return result;
    }
}

