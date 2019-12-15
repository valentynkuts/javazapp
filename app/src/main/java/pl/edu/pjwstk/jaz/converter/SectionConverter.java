package pl.edu.pjwstk.jaz.converter;

import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.product.jpa.Section;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


@FacesConverter(forClass = Section.class)
public class SectionConverter implements Converter {
    @Inject
    SectionRepository sectionRepository;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) throws ConverterException {
        // Convert Object to unique String representation for display.

        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof Section) {
            // System.out.println(String.valueOf(((Section) modelValue).getId()));
            return String.valueOf(((Section) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Section"));
        }
    }

//    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
//        if (modelValue == null) {
//            return "";
//        }
//
//        if (modelValue instanceof Warehouse) {
//            return String.valueOf(((Warehouse) modelValue).getId());
//        } else {
//            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
//        }
//    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) throws ConverterException {
        // Convert submitted unique String representation back to Object.
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            //System.out.println(sectionRepository.findSectionById(Long.valueOf(submittedValue)));
            return sectionRepository.findSectionById(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Section ID"), e);
        }
    }

}

//    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
//        if (submittedValue == null || submittedValue.isEmpty()) {
//            return null;
//        }
//
//        try {
//            return warehouseService.find(Long.valueOf(submittedValue));
//        } catch (NumberFormatException e) {
//            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
//        }
//    }
//---------------------
//    @Override
//    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
//        ValueExpression vex =
//                ctx.getApplication().getExpressionFactory()
//                        .createValueExpression(ctx.getELContext(),
//                                "#{beersBean}", BeersBean.class);
//
//        BeersBean beers = (BeersBean)vex.getValue(ctx.getELContext());
//        return beers.getBeer(Integer.valueOf(beerId));
//    }
//
//    @Override
//    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object beer) {
//        return ((Beer)beer).getId().toString();
//    }
//


