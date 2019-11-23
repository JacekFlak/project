package com.jacek.projekt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController implements ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String showErrorPage() {

        LOG.info("************************ showErrorPage() ************************");
        return "error";
    }
}