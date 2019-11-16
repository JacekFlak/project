package com.jacek.projekt.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class AddProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    /*private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);*/

    @RequestMapping(value = "/newproduct", method = RequestMethod.GET)
    public String productsForm(Model model) {
        model.addAttribute("product", new Product());
        return "newproduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String newProductAction(Product product, Model model) {
        String returnPage = "newproduct";
        Product foundProduct = productService.findProductByName(product.getProduct_name());
        productService.saveProduct(product);
        model.addAttribute("product", new Product());
        return returnPage;
    }

}