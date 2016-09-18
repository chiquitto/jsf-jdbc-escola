package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator("fotoValidator")
public class FotoValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file = (Part) value;

        FacesMessage msg = null;

        if (file == null) {
            msg = new FacesMessage("Arquivo não pode estar vazio");
        } else if (file.getSize() < 1024) {
            msg = new FacesMessage("Arquivo não tem o tamanho mínimo");
        } else if (!file.getContentType().equals("image/jpeg")) {
            msg = new FacesMessage("Arquivo deve ser uma foto JPG" + file.getContentType());
        }

        if (msg != null) {
            throw new ValidatorException(msg);
        }
    }

}
