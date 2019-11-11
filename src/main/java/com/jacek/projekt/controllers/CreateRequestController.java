package com.jacek.projekt.controllers;

import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import com.jacek.projekt.utilities.UserUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateRequestController {

    private static UserService userService;

    public CreateRequestController(UserService userService) {
        this.userService = userService;
    }

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping(value = "/newrequest", method = RequestMethod.GET)
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public String showCreateRequestPage(Model model) {
        LOG.info("************************ showRequestsPage() ************************");

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);

        return "newrequest";
    }
}