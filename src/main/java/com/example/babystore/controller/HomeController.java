package com.example.babystore.controller;

import com.example.babystore.model.view.ProductPictureAndNameView;
import com.example.babystore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<ProductPictureAndNameView> strollers =
                this.productService.getFourProductsByCategory(1L);

        model.addAttribute("strollers", strollers);

        List<ProductPictureAndNameView> toys =
                this.productService.getFourProductsByCategory(5L);

        model.addAttribute("toys", toys);

        List<ProductPictureAndNameView> babyClothes =
                this.productService.getFourProductsByCategory(3L);

        model.addAttribute("babyClothes", babyClothes);

        return "index";
    }
}
