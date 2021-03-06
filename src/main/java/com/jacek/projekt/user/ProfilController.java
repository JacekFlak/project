package com.jacek.projekt.user;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.utilities.UserUtilities;
import com.jacek.projekt.validators.ChangePasswordValidator;
import com.jacek.projekt.validators.EditUserProfileValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class ProfilController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    private final UserService userService;

    private final MessageSource messageSource;

    @GetMapping("/profile")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN", "ROLE_PRICING", "ROLE_TRADER"})
    public String showUserProfilePage(Model model) {
        LOG.info("************************ showProfilePage() ************************");

        String username = UserUtilities.getLoggedUser();

        User user = userService.findUserByEmail(username);

        int nrRoli = user.getRoles().iterator().next().getId();

        user.setNrRoli(nrRoli);

        model.addAttribute("user", user);

        return "profile";
    }

    @GetMapping("/editpassword")
    public String editUserPassword(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);
        return "editpassword";
    }

    @PostMapping("/updatepass")
    public String changeUSerPassword(User user, BindingResult result, Model model, Locale locale) {
        String returnPage = null;
        new ChangePasswordValidator().validate(user, result);
        new ChangePasswordValidator().checkPasswords(user.getNewPassword(), result);
        if (result.hasErrors()) {
            returnPage = "editpassword";
        } else {
            userService.updateUserPassword(user.getNewPassword(), user.getEmail());
            returnPage = "editpassword";
            model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
        }
        return returnPage;
    }

    @GetMapping("/editprofile")
    public String changeUserData(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);
        return "editprofile";
    }

    @PostMapping("/updateprofile")
    public String changeUserDataAction(User user, BindingResult result, Model model, Locale locale) {
        String returnPage;
        new EditUserProfileValidator().validate(user, result);
        if (result.hasErrors()) {
            returnPage = "editprofile";
        } else {
            userService.updateUserProfile(user.getName(), user.getLastName(), user.getEmail(), user.getId());
            model.addAttribute("message", messageSource.getMessage("profileEdit.success", null, locale));
            returnPage = "afteredition";
        }
        return returnPage;
    }
}
