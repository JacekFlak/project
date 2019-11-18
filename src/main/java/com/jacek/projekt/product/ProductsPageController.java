package com.jacek.projekt.product;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.user.User;
import com.jacek.projekt.user.UserService;
import com.jacek.projekt.utilities.UserUtilities;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProductsPageController {

    private static int ELEMENTS = 10;

    private final ProductService productService;

    private final UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping(value = "/trader", method = RequestMethod.GET)
    @Secured(value = {"ROLE_TRADER"})
    public String openProductsPage(Model model) {
        LOG.info("************************ openTraderPage() ************************");

        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        model.addAttribute("user", user);

        return "trader/trader";
    }

    @RequestMapping(value = "/trader/products/{page}", method = RequestMethod.GET)
    @Secured(value = {"ROLE_TRADER"})
    public String openTraderAllProductsPage(@PathVariable("page") int page, Model model) {
        Page<Product> pages = getAllProductsPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<Product> productList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("productList", productList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);

        return "trader/products";
    }

    private Page<Product> getAllProductsPageable(int page) {
        Page<Product> pages = productService.findAll(PageRequest.of(page, ELEMENTS));
        for (Product products : pages) {
        }
        return pages;
    }

}
