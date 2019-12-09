package com.jacek.projekt.request;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.product.Product;
import com.jacek.projekt.product.ProductService;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.store.StoreService;
import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import com.jacek.projekt.utilities.UserUtilities;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RequestsPageController {

    private static int ELEMENTS = 10;

    private final RequestService requestService;
    private final StoreService storeService;
    private final ProductService productService;
    private final UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/user")
    @Secured(value = {"ROLE_USER","ROLE_PRICING"})
    public String openRequestsPage(Model model) {
        LOG.info("************************ openRequestsPage() ************************");

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);

        return "user/user";
    }

    @GetMapping("/user/requests/{page}")
    @Secured(value = {"ROLE_USER"})
    public String openUserAllRequestsPage(@PathVariable("page") int page, Model model) {
        Page<Request> pages = getAllRequestsPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<Request> requestList = pages.getContent();

        List<Store> storeList = requestList.stream()
                .map(Request::getStore)
                .collect(Collectors.toList());

        List<Product> productList = requestList.stream()
                .map(Request::getProduct)
                .collect(Collectors.toList());

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("requestList", requestList);
        model.addAttribute("storeList", storeList);
        model.addAttribute("productList", productList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);

        return "user/requests";
    }

    @GetMapping("/user/confirmrequests/{page}")
    @Secured(value = {"ROLE_PRICING"})
    public String openUserAllRequestsToConfirmPage(@PathVariable("page") int page, Model model) {
        Page<Request> pages = getAllRequestsPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<Request> requestList = pages.getContent();

        List<Store> storeList = requestList.stream()
                .map(Request::getStore)
                .collect(Collectors.toList());

        List<Product> productList = requestList.stream()
                .map(Request::getProduct)
                .collect(Collectors.toList());

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("requestList", requestList);
        model.addAttribute("storeList", storeList);
        model.addAttribute("productList", productList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);

        return "user/confirmrequests";
    }


    private Page<Request> getAllRequestsPageable(int page) {
        Page<Request> pages = requestService.findAll(PageRequest.of(page, ELEMENTS));
        for (Request requests : pages) {
        }
        return pages;
    }

}