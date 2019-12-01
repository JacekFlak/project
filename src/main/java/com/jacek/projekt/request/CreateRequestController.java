package com.jacek.projekt.request;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.product.Product;
import com.jacek.projekt.product.ProductService;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.store.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CreateRequestController {

    private StoreService storeService;

    private ProductService productService;

    public CreateRequestController(StoreService storeService, ProductService productService) {
        this.storeService = storeService;
        this.productService = productService;
    }

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/newrequest")
    @Secured(value = {"ROLE_USER"})
    public String showCreateRequestPage(Model model) {
        model.addAttribute("request", new Request());
        LOG.info("************************ showRequestsPage() ************************");

        List<Store> storeList = storeService.findAll();
        List<Product> productList = productService.findAll();

        model.addAttribute("storeList", storeList);
        model.addAttribute("productList", productList);

        return "newrequest";
    }

}