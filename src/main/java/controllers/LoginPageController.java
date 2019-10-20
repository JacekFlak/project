package controllers;

import javax.ws.rs.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GET
    @RequestMapping(value = "/login")
    public String showLoginPage() {
        LOG.info("************ showLoginPage()");
        return "login";
    }

}
