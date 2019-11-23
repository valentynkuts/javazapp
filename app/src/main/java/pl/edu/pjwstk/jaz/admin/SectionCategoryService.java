package pl.edu.pjwstk.jaz.admin;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SectionCategoryService {
    @Inject
    private SectionCategoryRepository scr;

    public void addSection(String name){
        scr.addSection(name);
    }
    public void addCategory(String name){
        scr.addCategory(name);
    }
}
