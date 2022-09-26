package com.example.babystore.web;

import com.example.babystore.model.entity.User;
import com.example.babystore.model.view.CartView;
import com.example.babystore.service.CartService;
import com.example.babystore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class CartController {

    private final UserService userService;
    private final CartService cartService;

    public CartController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String cart(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/users/login";
        }
        User user = this.userService.findByUsername(principal.getName());

        CartView cart = this.cartService.getCurrentUserCart(user);

        model.addAttribute("cart", cart);

        return "cart";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addProductToCart(@PathVariable("id") Long id,
                                   Principal principal) {

        if (principal == null) {
            return "redirect:/users/login";
        }

        User user = this.userService.findByUsername(principal.getName());
        this.cartService.addItemToCart(id, user);

        return "redirect:/offers";
    }

    @DeleteMapping("/cart/delete/{id}")
    public String deleteItem(@PathVariable("id") String id, Principal principal) {
        Long itemId = Long.parseLong(id);
        User user = this.userService.findByUsername(principal.getName());
        this.cartService.deleteCartItem(itemId, user);

        return "redirect:/cart";
    }
}
