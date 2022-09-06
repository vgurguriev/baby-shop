package com.example.babystore.service;

import com.example.babystore.model.entity.Cart;
import com.example.babystore.model.entity.CartItem;
import com.example.babystore.model.entity.Product;
import com.example.babystore.model.entity.User;
import com.example.babystore.model.view.CartView;
import com.example.babystore.repository.CartItemRepository;
import com.example.babystore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Service
public class CartService {

    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public CartService(ProductService productService, CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    public void addItemToCart(Long id, User user) {
        Product product = this.productService.findProductById(id);
//        TODO: fix quantity
        int quantity = 1;
        Cart cart = user.getCart();

        if (cart == null) {
            cart = new Cart();
        }

        Set<CartItem> cartItems = cart.getCartItems();

        if (cartItems == null) {
            cartItems = new HashSet<>();
        }

        CartItem cartItem = new CartItem()
                .setProduct(product)
                .setTotalPrice(BigDecimal.valueOf(quantity)
                        .multiply(product.getPrice()))
                .setQuantity(quantity)
                .setCart(cart);

        cartItems.add(cartItem);
        this.cartItemRepository.save(cartItem);

        cart.setTotalPrice(itemsTotalPrice(cartItems));
        cart.setCartItems(cartItems);
        cart.setUser(user);
        this.cartRepository.save(cart);
    }

    public BigDecimal itemsTotalPrice(Set<CartItem> cartItems) {
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem cartItem : cartItems) {
            total = total.add(cartItem.getTotalPrice());
        }

        return total;
    }

    public CartView getCurrentUserCart(Principal principal) {
        return null;
    }
}
