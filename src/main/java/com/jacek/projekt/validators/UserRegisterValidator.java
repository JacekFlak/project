package com.jacek.projekt.validators;

import com.jacek.projekt.constants.AppDemoConstants;
import com.jacek.projekt.user.User;
import com.jacek.projekt.utilities.AppDemoUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (u.getEmail() != null) {
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.EMAIL_PATTERN, (String) u.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

        if (u.getPassword() != null) {
            boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.PASSWORD_PATTERN, u.getPassword());
            if (!isMatch) {
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }
    }

    public void validateEmailExist(User user, User foundUser, Errors errors) {
        if (foundUser != null && user != null) {
            if (foundUser.getEmail().equals(user.getEmail())) {
                errors.rejectValue("email", "error.userEmailExist");
            }
        }
    }
}