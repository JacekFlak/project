package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminPageController {

    private final AdminService adminService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminMainPage() {
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/users/{page}", method = RequestMethod.GET)
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminAllUsersPage(@PathVariable("page") int page, Model model) {
        Page<User> pages = getAllUsersPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<User> userList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", userList);
        return "admin/users";
    }

    //Pobranie listy użytkowników
    private Page<User> getAllUsersPageable(int page) {
        int elements = 5;
        Page<User> pages = adminService.findAll(PageRequest.of(page, elements));
        for (User users : pages) {
            int numerRoli = users.getRoles().iterator().next().getId();
            users.setNrRoli(numerRoli);
        }
        return pages;
    }
}
