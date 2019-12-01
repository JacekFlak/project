package com.jacek.projekt.validators;

import com.jacek.projekt.request.Request;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CreateRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Request.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Request r = (Request) obj;

        /*ValidationUtils.rejectIfEmpty(errors, "name", "error.productName.empty");
        ValidationUtils.rejectIfEmpty(errors, "price_per_pack", "error.pricePerPack.empty");
        ValidationUtils.rejectIfEmpty(errors, "quantity_per_pack", "error.quantityPerPack.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "error.description.empty");*/
    }
}

