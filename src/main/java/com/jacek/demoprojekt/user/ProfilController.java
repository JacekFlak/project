package com.jacek.demoprojekt.user;

import com.jacek.demoprojekt.utilities.UserUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
@RequiredArgsConstructor
public class ProfilController {

    private final UserService userService;

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
}
