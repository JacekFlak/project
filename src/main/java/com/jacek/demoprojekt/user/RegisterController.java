package com.jacek.demoprojekt.user;

import controllers.MainPageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        logger.info("Request got -> RegisterController");
        return "register";
    }
}

