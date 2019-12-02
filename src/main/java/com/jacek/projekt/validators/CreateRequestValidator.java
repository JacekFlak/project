package com.jacek.projekt.validators;

import com.jacek.projekt.request.Request;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreateRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Request.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Request r = (Request) obj;

        ValidationUtils.rejectIfEmpty(errors, "quantity", "error.quantityPerPack.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "error.description.empty");
    }
}

