package com.jacek.projekt.validators;

import com.jacek.projekt.constants.AppDemoConstants;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.utilities.AppDemoUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class NewStoreValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Store.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Store s = (Store) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.store.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "street", "error.store.street.empty");
        ValidationUtils.rejectIfEmpty(errors, "number", "error.store.number.empty");
        ValidationUtils.rejectIfEmpty(errors, "city", "error.store.city.empty");
        ValidationUtils.rejectIfEmpty(errors, "country", "error.store.country.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.store.email.empty");
        ValidationUtils.rejectIfEmpty(errors, "phone", "error.store.phone.empty");

        if (s.getEmail() != null) {
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.EMAIL_PATTERN, (String) s.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

    }
}

