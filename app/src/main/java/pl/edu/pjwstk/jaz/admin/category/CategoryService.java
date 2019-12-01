package pl.edu.pjwstk.jaz.admin.category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CategoryService {
    @Inject
    private CategoryRepository cr;

//    public void addCategory(String name){
//        cr.addCategory(name);
//    }

}
