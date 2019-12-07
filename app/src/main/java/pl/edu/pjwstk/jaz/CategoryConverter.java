package pl.edu.pjwstk.jaz;

        import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
        import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
        import pl.edu.pjwstk.jaz.product.jpa.Category;
        import pl.edu.pjwstk.jaz.product.jpa.Section;

        import javax.faces.application.FacesMessage;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.ConverterException;
        import javax.faces.convert.FacesConverter;
        import javax.inject.Inject;


@FacesConverter(forClass = Category.class)
public class CategoryConverter implements Converter {
    @Inject
    CategoryRepository categoryRepository;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) throws ConverterException {
        // Convert Object to unique String representation for display.

        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof Category) {
            // System.out.println(String.valueOf(((Category) modelValue).getId()));
            return String.valueOf(((Category) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Category"));
        }
    }


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) throws ConverterException {
        // Convert submitted unique String representation back to Object.
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            //System.out.println(sectionRepository.findSectionById(Long.valueOf(submittedValue)));
            return categoryRepository.findCategoryById(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
        }
    }

}




