package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminMainPage() {
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    @Secured(value = {"ROLE_ADMIN"})

    public String openAdminAllUsersPage(Model model) {

        List<User> userList = getAllUsers();
        model.addAttribute("userList", userList);
        return "admin/users";
    }
    //Pobranie listy użytkowników
    private List<User> getAllUsers() {
        List<User> usersList = userService.findAll();
        for (User users : usersList) {
            int numerRoli = users.getRoles().iterator().next().getId();
          /*  if (numerRoli == 1) {
                users.setNrRoli(numerRoli);
            } else if (numerRoli == 2) {
                users.setNrRoli(numerRoli);
            }*/
            users.setNrRoli(numerRoli);
        }
        return usersList;
    }
}
