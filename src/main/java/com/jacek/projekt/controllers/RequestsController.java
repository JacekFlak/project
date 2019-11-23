package com.jacek.projekt.controllers;

import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import com.jacek.projekt.utilities.UserUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestsController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    private final UserService userService;

    public RequestsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/requests")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public String showRequestsPage(Model model) {
        LOG.info("************************ showRequestsPage() ************************");

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);

        return "requests";
    }
}