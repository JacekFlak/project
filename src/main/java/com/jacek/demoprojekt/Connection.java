package com.jacek.demoprojekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class Connection {

    private final Logger logger = LoggerFactory.getLogger(Connection.class);

    @GetMapping("/test")
    protected String doGet(HttpServletRequest req) throws ServletException, IOException {
        logger.info("Request got -> test");
        return "index";
    }

}
