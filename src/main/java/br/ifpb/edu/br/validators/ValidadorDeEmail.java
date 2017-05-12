package br.ifpb.edu.br.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank">dijalma</a> on 11/05/17.
 */
@FacesValidator("validadorDeEmail")
public class ValidadorDeEmail implements Validator {


    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = String.valueOf(o);
        isEmail(email);
    }

    private void isEmail(String email) {
        if (!(email.contains("@") && email.contains(".com"))) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido",
                    "O email deve conter '@' e '.com'. Exemplo: example@example.com'");
            throw new ValidatorException(message);
        }
    }
}
