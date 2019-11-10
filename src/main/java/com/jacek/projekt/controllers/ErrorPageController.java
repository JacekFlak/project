package com.jacek.projekt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorPageController implements ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showErrorPage() {

        LOG.info("************************ showErrorPage() ************************");
        return "error";
    }
}