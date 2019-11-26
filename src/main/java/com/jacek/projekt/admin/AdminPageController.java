package com.jacek.projekt.admin;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import com.jacek.projekt.utilities.UserUtilities;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.DELETE;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminPageController {

    private static int ELEMENTS = 10;

    private final AdminService adminService;

    private final MessageSource messageSource;

    private final UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminMainPage(Model model) {
        LOG.info("************************ openAdminMainPage() ************************");

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);

        return "admin/admin";
    }

    @GetMapping("/admin/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String openAdminAllUsersPage(@PathVariable("page") int page, Model model) {
        Page<User> pages = getAllUsersPageable(page - 1, false, null);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<User> userList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", userList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
        return "admin/users";
    }

    @GetMapping("/admin/users/edit/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String getUserToEdit(@PathVariable("id") int id, Model model) {
        User user = new User();
        user = adminService.findUserById(id);

        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap = prepareRoleMap();

        Map<Integer, String> activityMap = new HashMap<Integer, String>();
        activityMap = prepareActivityMap();

        int rola = user.getRoles().iterator().next().getId();
        user.setNrRoli(rola);
        model.addAttribute("roleMap", roleMap);
        model.addAttribute("activityMap", activityMap);
        model.addAttribute("user", user);

        return "admin/useredit";
    }

    @PostMapping("/admin/updateuser/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String updateUser(@PathVariable("id") int id, User user) {
        int nrRoli = user.getNrRoli();
        int isActive = user.getActive();
        adminService.updateUser(id, nrRoli, isActive);
        return "redirect:/admin/users/1";
    }

    @DELETE
    @RequestMapping(value = "/admin/users/delete/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String deleteUser(@PathVariable("id") int id) {
        LOG.debug(" >>>>>>>>>>>>>>>> AdminPageController.deleteUser -> " + id);
        adminService.deleteUserById(id);
        return "redirect:/admin/users/1";
    }

    @GetMapping("/admin/users/search/{searchWord}/{page}")
    @Secured(value = "ROLE_ADMIN")
    public String openSearchUsersPage(@PathVariable("searchWord") String searchWord,
                                      @PathVariable("page") int page, Model model) {
        Page<User> pages = getAllUsersPageable(page - 1, true, searchWord);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<User> userList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("userList", userList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("userList", userList);
        return "admin/usersearch";
    }

    //Pobranie listy użytkowników
    private Page<User> getAllUsersPageable(int page, boolean search, String param) {
        Page<User> pages;
        if (!search) {
            pages = adminService.findAll(PageRequest.of(page, ELEMENTS));
        } else {
            pages = adminService.findAllSearch(param, PageRequest.of(page, ELEMENTS));
        }
        for (User users : pages) {
            int numerRoli = users.getRoles().iterator().next().getId();
            users.setNrRoli(numerRoli);
        }
        return pages;
    }

    // przygotowanie mapy ról
    public Map<Integer, String> prepareRoleMap() {
        Locale locale = Locale.getDefault();
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
        roleMap.put(2, messageSource.getMessage("word.user", null, locale));
        roleMap.put(3, messageSource.getMessage("word.pricing", null, locale));
        roleMap.put(4, messageSource.getMessage("word.trader", null, locale));
        return roleMap;
    }

    // przygotowanie map aktywny/nieaktywny
    public Map<Integer, String> prepareActivityMap() {
        Locale locale = Locale.getDefault();
        Map<Integer, String> activityMap = new HashMap<Integer, String>();
        activityMap.put(0, messageSource.getMessage("word.no", null, locale));
        activityMap.put(1, messageSource.getMessage("word.yes", null, locale));
        return activityMap;
    }

}
