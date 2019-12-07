package com.jacek.projekt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactSupportController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/contact")
    public String showContactSupportPage() {
        LOG.info("************************ showContactSupportPage() ************************");
        return "contact";
    }
}