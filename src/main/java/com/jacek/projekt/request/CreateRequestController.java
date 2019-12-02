package com.jacek.projekt.request;

import com.jacek.projekt.controllers.MainPageController;
import com.jacek.projekt.product.Product;
import com.jacek.projekt.product.ProductService;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.store.StoreService;
import com.jacek.projekt.validators.CreateRequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class CreateRequestController {

    private RequestService requestService;
    private StoreService storeService;
    private ProductService productService;
    private MessageSource messageSource;

    public CreateRequestController(RequestService requestService, StoreService storeService, ProductService productService, MessageSource messageSource) {
        this.requestService = requestService;
        this.storeService = storeService;
        this.productService = productService;
        this.messageSource = messageSource;
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

    @PostMapping("/addrequest")
    public String CreateNewRequestAction(Request request, BindingResult result, Model model, Locale locale, Store storeId, Product productId) {
        String returnPage = "newrequest";

        new CreateRequestValidator().validate(request, result);

        if (!result.hasErrors()) {
            model.addAttribute("storeName", storeId);
            model.addAttribute("productName", productId);
            requestService.saveRequest(request, storeId, productId);
            model.addAttribute("message", messageSource.getMessage("request.creation.success", null, locale));
            model.addAttribute("request", new Request());

        }
        return returnPage;
    }

}