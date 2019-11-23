package com.jacek.projekt.store;

import com.jacek.projekt.controllers.MainPageController;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoresPageController {

    private static int ELEMENTS = 10;

    private final StoreService storeService;

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping("/trader/stores/{page}")
    @Secured(value = {"ROLE_TRADER"})
    public String openTraderAllStoresPage(@PathVariable("page") int page, Model model) {
        LOG.info("************************ showStoresPage() ************************");
        Page<Store> pages = getAllStoresPageable(page - 1);
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<Store> storeList = pages.getContent();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage + 1);
        model.addAttribute("storeList", storeList);
        model.addAttribute("recordStartCounter", currentPage * ELEMENTS);

        return "trader/stores";
    }

    private Page<Store> getAllStoresPageable(int page) {
        Page<Store> pages = storeService.findAll(PageRequest.of(page, ELEMENTS));
        for (Store stores : pages) {
        }
        return pages;
    }

}

