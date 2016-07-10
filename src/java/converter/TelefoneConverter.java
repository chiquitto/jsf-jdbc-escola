package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("telefoneConverter")
public class TelefoneConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String str = (String) value;
        String retorno = "";

        if (!str.isEmpty()) {
            retorno += "(";
            retorno += str.substring(0, 2);
            retorno += ") ";
            retorno += str.substring(2, 6);
            retorno += "-";
            retorno += str.substring(6);
        }

        return retorno;
    }

}
