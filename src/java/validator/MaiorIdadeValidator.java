package validator;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("maiorIdadeValidator")
public class MaiorIdadeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Calendar minimo = Calendar.getInstance();
        minimo.add(Calendar.YEAR, -18);
        
        Calendar nascCalendar = Calendar.getInstance();
        nascCalendar.setTime((Date) value);
        
        if (minimo.before(nascCalendar)) {
            // Menor que 18 anos
            FacesMessage msg = new FacesMessage("Idade deve ser maior que 18 anos");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            
            throw new ValidatorException(msg);
        }
    }
    
}
