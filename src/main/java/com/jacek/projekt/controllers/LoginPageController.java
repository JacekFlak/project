package com.jacek.projekt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        LOG.info("************************ showLoginPage() ************************");
        return "login";
    }

}
