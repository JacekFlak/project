package com.jacek.demoprojekt.user;

import com.jacek.demoprojekt.validators.UserRegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final MessageSource messageSource;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale) {
        String returnPage = "register";
        User foundUser = userService.findUserByEmail(user.getEmail());
        new UserRegisterValidator().validateEmailExist(user, foundUser, result);
        new UserRegisterValidator().validate(user, result);

        if (!result.hasErrors()) {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("user", new User());
        }
        return returnPage;
    }
}