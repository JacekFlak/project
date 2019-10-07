package com.jacek.demoprojekt.controllers;

import com.jacek.demoprojekt.services.UserServiceLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    UserServiceLogic userServiceLogic;

    private final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @GetMapping("/login")
    public String Login() {

        logger.info("Request got -> test");

        return "login";
    }
}