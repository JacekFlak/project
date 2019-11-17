package com.jacek.projekt.store;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class AddStoreController {

    private final StoreService storeService;
    private final MessageSource messageSource;

    /*private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);*/

    @RequestMapping(value = "/newstore", method = RequestMethod.GET)
    public String storesForm(Model model) {
        model.addAttribute("store", new Store());
        return "newstore";
    }

    @RequestMapping(value = "/addstore", method = RequestMethod.POST)
    public String newStoreAction(Store store, Model model, Locale locale) {
        String returnPage = "newstore";
        Store foundStore = storeService.findStoreByName(store.getName());
        storeService.saveStore(store);
        model.addAttribute("message", messageSource.getMessage("store.added.success", null, locale));
        model.addAttribute("store", new Store());
        return returnPage;
    }
}