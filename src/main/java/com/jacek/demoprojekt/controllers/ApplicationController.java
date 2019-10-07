package com.jacek.demoprojekt.controllers;

import com.jacek.demoprojekt.services.UserServiceLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    @Autowired
    UserServiceLogic userServiceLogic;

    private final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @GetMapping(value = "/login")
    protected String Login() {
        logger.info("Request got -> test");
        return "loginpage";
    }
}