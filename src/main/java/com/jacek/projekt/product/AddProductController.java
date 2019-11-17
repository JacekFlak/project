package com.jacek.projekt.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jacek.projekt.validators.NewProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class AddProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    private static final Logger LOG = LoggerFactory.getLogger(AddProductController.class);

    @RequestMapping(value = "/newproduct", method = RequestMethod.GET)
    public String productsForm(Model model) {
        model.addAttribute("product", new Product());
        LOG.info("************************ showAddProductPage() ************************");
        return "newproduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String newProductAction(Product product, BindingResult result, Model model, Locale locale) {
        String returnPage = "newproduct";

        new NewProductValidator().validate(product, result);
        if (!result.hasErrors()) {
            productService.saveProduct(product);
            model.addAttribute("message", messageSource.getMessage("product.added.success", null, locale));
            model.addAttribute("product", new Product());
        }
        return returnPage;
    }

}
