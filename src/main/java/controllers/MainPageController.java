package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class MainPageController {

    private final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @GET
    @RequestMapping("/")
    public String showMainPAge() {
        logger.info("Request got -> MainPage");
        return "index";
    }
}
