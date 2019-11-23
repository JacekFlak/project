package com.jacek.projekt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/login")
    public String showLoginPage() {
        LOG.info("************************ showLoginPage() ************************");
        return "login";
    }
}
