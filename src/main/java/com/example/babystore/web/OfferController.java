package com.example.babystore.web;
import com.example.babystore.model.view.CategoryView;
import com.example.babystore.model.view.OfferView;
import com.example.babystore.service.CategoryService;
import com.example.babystore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final CategoryService categoryService;

    private final ProductService productService;

    public OfferController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping()
    public String mommyCategories(Model model) {
        List<CategoryView> categoryViewList =
                this.categoryService.getCategories();

        model.addAttribute("categories", categoryViewList);

        List<OfferView> allOffers = this.productService
                .getAllProducts();

        model.addAttribute("allOffers", allOffers);

        return "offers";
    }
}
