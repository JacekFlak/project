package com.jacek.demoprojekt.controllers;

import com.jacek.demoprojekt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationRestController {

    @Autowired
    private com.jacek.demoprojekt.services.UserServiceLogic UserServiceLogic;

    @GetMapping("/")
    public String hello() {
        return "Home page";
    }

    @GetMapping("/save-user")
    public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String password) {

        User user = new User(username, firstname, lastname, password);
        UserServiceLogic.saveMyUser(user);
        return "User saved";
    }

}
