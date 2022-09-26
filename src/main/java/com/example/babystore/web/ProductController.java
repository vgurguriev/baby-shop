package com.example.babystore.web;
import com.example.babystore.model.dto.AddProductDto;
import com.example.babystore.model.view.ProductView;
import com.example.babystore.service.BrandService;
import com.example.babystore.service.CategoryService;
import com.example.babystore.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final BrandService brandService;

    public ProductController(ProductService productService, CategoryService categoryService, BrandService brandService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    @ModelAttribute("addProductDto")
    public AddProductDto addProductDto() {
        return new AddProductDto();
    }

    @GetMapping("/add")
    public String getProduct(Model model) {

        model.addAttribute("categories", this.categoryService
                .getCategories());

        model.addAttribute("brands", this.brandService
                .getBrands());

        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddProductDto addProductDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails userDetails) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addProductDto", addProductDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductDto",
                    bindingResult);
            return "redirect:/product/add";
        }

        this.productService.addProduct(addProductDto, userDetails);

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    String details(@PathVariable("id") Long id,
                   Model model) {

        ProductView productView = this.productService.findAndConvertProductById(id);
        return "product-details";
    }
}
