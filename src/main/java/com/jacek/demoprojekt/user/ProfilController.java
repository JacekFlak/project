package com.jacek.demoprojekt.user;

import com.jacek.demoprojekt.utilities.UserUtilities;
import com.jacek.demoprojekt.validators.ChangePasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class ProfilController {

    private final UserService userService;

    private final MessageSource messageSource;

    @GET
    @RequestMapping(value = "/profile")
    public String showUserProfilePage(Model model) {
        String username = UserUtilities.getLoggedUser();

        User user = userService.findUserByEmail(username);

        int nrRoli = user.getRoles().iterator().next().getId();

        user.setNrRoli(nrRoli);

        model.addAttribute("user", user);

        return "profile";
    }

    @GET
    @RequestMapping(value = "/editpassword")
    public String editUserPassword(Model model) {
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);
        return "editpassword";
    }

    @POST
    @RequestMapping(value = "/updatepass")
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

}
