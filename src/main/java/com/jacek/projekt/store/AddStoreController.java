package com.jacek.projekt.store;

import com.jacek.projekt.validators.NewStoreValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class AddStoreController {

    private final StoreService storeService;
    private final MessageSource messageSource;

    private static final Logger LOG = LoggerFactory.getLogger(AddStoreController.class);

    @GetMapping("/newstore")
    public String storesForm(Model model) {
        model.addAttribute("store", new Store());
        LOG.info("************************ showAddStorePage() ************************");
        return "newstore";
    }

    @PostMapping("/addstore")
    public String newStoreAction(Store store, BindingResult result, Model model, Locale locale) {
        new NewStoreValidator().validate(store, result);
        if (!result.hasErrors()) {
            storeService.saveStore(store);
            model.addAttribute("message", messageSource.getMessage("store.added.success", null, locale));
            model.addAttribute("store", new Store());
        }
        return "newstore";
    }

}