package com.example.babystore.controller;

import com.example.babystore.model.dto.OrderDto;
import com.example.babystore.model.entity.User;
import com.example.babystore.model.view.CartView;
import com.example.babystore.service.CartService;
import com.example.babystore.service.OrderService;
import com.example.babystore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;
    private final UserService userService;
    private final OrderService orderService;

    public OrderController(CartService cartService, UserService userService, OrderService orderService) {
        this.cartService = cartService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @ModelAttribute("orderDto")
    public OrderDto orderDto() {
        return new OrderDto();
    }

    @GetMapping
    public String getOrder(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/users/login";
        }

        User user = this.userService.findByUsername(principal.getName());
        CartView cart = this.cartService.getCurrentUserCart(user);

        model.addAttribute("cart", cart);
        return "order";
    }

    @PostMapping
    public String addOrder(@Valid OrderDto orderDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderDto", orderDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.orderDto", bindingResult);
            return "redirect:/order";
        }
        User user = this.userService.findByUsername(principal.getName());
        this.orderService.addOrder(orderDto, user);
        return "redirect:/";
    }
}
