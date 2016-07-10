package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("uppercaseConverter")
public class UppercaseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return ((String) value).toUpperCase();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }
    
}
