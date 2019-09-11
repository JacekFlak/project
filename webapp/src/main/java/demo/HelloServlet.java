package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class HelloServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @GetMapping("/test")
    protected String doGet(HttpServletRequest req) throws ServletException, IOException {
        logger.info("Request got");
        return "Działam :)";
    }
}