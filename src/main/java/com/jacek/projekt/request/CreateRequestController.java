package com.jacek.projekt.request;

import com.jacek.projekt.controllers.MainPageController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateRequestController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping(value = "/newrequest", method = RequestMethod.GET)
    @Secured(value = {"ROLE_USER"})
    public String showCreateRequestPage(Model model) {
        model.addAttribute("request", new Request());
        LOG.info("************************ showRequestsPage() ************************");
        return "newrequest";
    }
}