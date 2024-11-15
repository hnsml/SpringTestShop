package org.example.springshop.controllers;

import java.util.Optional;
import org.example.springshop.models.Shop;
import org.example.springshop.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("shops", shopService.getAllShops());
        return "index";
    }

    @GetMapping("/shop/{id}")
    public String viewShop(@PathVariable Long id, Model model) {
        Optional<Shop> shop = shopService.getShopById(id);
        shop.ifPresent(value -> model.addAttribute("shop", value));
        return shop.map(value -> "view_shop").orElse("redirect:/");
    }

    @PostMapping("/shop/add")
    public String addShop(Model model, Shop shop) {
        shopService.addShop(shop);
        return "redirect:/";
    }

    @GetMapping("/shop/add")
    public String addShopForm(Model model, Shop shop) {
        model.addAttribute("shop", shop);
        return "add_shop";
    }

    @PostMapping("/shop/edit")
    public String editShop(Model model, Shop shop) {
        shopService.addShop(shop);
        return "redirect:/";
    }

    @GetMapping("/shop/edit/{id}")
    public String editShopForm(Model model, @PathVariable Long id) {
        Optional<Shop> shop = shopService.getShopById(id);
        if (shop.isPresent()) {
            model.addAttribute("shop", shop);
            return "edit_shop.html";
        }
        return "redirect:/";
    }

    @PostMapping("/shop/delete/{id}")
    public String deleteShop(Model model, @PathVariable Long id) {
        shopService.deleteShop(id);
        return "redirect:/";
    }

    @GetMapping("/shop/search")
    public String searchShops(String query, Model model) {
        model.addAttribute("shops", shopService.searchShops(query));
        return "index";
    }

}
