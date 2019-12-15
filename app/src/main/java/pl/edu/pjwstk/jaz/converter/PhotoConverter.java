package pl.edu.pjwstk.jaz.converter;

import pl.edu.pjwstk.jaz.product.jpa.Photo;
import pl.edu.pjwstk.jaz.user.product.add.photo.PhotoRepository;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Photo.class)
public class PhotoConverter implements Converter {
    @Inject
    PhotoRepository photoRepository;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) throws ConverterException {
        // Convert Object to unique String representation for display.

        if (modelValue == null) {
            return "";
        }
        if (modelValue instanceof Photo) {
            // System.out.println(String.valueOf(((Category) modelValue).getId()));
            return String.valueOf(((Photo) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Photo"));
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
            return photoRepository.findPhotoById(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Product ID"), e);
        }
    }

}
