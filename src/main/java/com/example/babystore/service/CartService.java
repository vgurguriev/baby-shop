package com.example.babystore.service;

import com.example.babystore.model.entity.Cart;
import com.example.babystore.model.entity.CartItem;
import com.example.babystore.model.entity.Product;
import com.example.babystore.model.entity.User;
import com.example.babystore.model.view.CartView;
import com.example.babystore.repository.CartItemRepository;
import com.example.babystore.repository.CartRepository;
import com.example.babystore.repository.ProductRepository;
import com.example.babystore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CartService {

    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CartService(ProductService productService, CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void addItemToCart(Long id, User user) {
        Product product = this.productService.findProductById(id);
//
        Cart cart = user.getCart();

        Set<CartItem> cartItems = cart.getCartItems();


        CartItem cartItem = new CartItem()
                .setProduct(product)
                .setSubPrice(BigDecimal.valueOf(1)
                        .multiply(product.getPrice()))
                .setQuantity(1)
                .setCart(cart);



        for (CartItem item : cartItems) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.setQuantity(cartItem.getQuantity() + 1);
                item.setSubPrice(BigDecimal.valueOf(item.getQuantity())
                        .multiply(product.getPrice()));
                this.cartItemRepository.save(item);
                cart.setTotalPrice(itemsTotalPrice(cartItems));
                this.cartRepository.save(cart);
                return;
            }
        }

        product.setCartItem(cartItem);
        this.productRepository.save(product);

        cartItems.add(cartItem);
        cart.setTotalPrice(itemsTotalPrice(cartItems));
        this.cartRepository.save(cart);
    }

    public BigDecimal itemsTotalPrice(Set<CartItem> cartItems) {
        BigDecimal total = BigDecimal.ZERO;

        for (CartItem cartItem : cartItems) {
            total = total.add(cartItem.getSubPrice());
        }

        return total;
    }

    public CartView getCurrentUserCart(User user) {
        return this.cartRepository.findById(user.getCart().getId())
                .stream()
                .map(cart -> new CartView()
                        .setCartItems(cart.getCartItems())
                        .setId(cart.getId())
                        .setTotalPrice(cart.getTotalPrice()))
                .findFirst()
                .orElseThrow();
    }

    public void deleteCartItem(Long id, User user) {
        Cart cart = user.getCart();

        CartItem item = this.cartItemRepository
                .findByProductId(id);

        Product product = item.getProduct();

        item.setProduct(null);
        product.setCartItem(null);
        item.setCart(null);
        cart.getCartItems().remove(item);
        cart.setTotalPrice(cart.getTotalPrice().subtract(item.getSubPrice()));
        this.productRepository.save(product);
        this.cartItemRepository.save(item);
        this.cartRepository.save(cart);
    }
}
