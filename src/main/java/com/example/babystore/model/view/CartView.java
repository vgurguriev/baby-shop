package com.example.babystore.model.view;

import com.example.babystore.model.entity.CartItem;
import com.example.babystore.model.entity.User;

import java.math.BigDecimal;
import java.util.Set;

public class CartView {
    private Long id;
    private BigDecimal totalPrice;
    private Set<CartItem> cartItems;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public CartView setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public CartView setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CartView setId(Long id) {
        this.id = id;
        return this;
    }
}
