package com.example.babystore.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private Set<CartItem> cartItems;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Cart() {
    }
    public Long getId() {
        return id;
    }

    public Cart setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Cart setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public Cart setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Cart setUser(User user) {
        this.user = user;
        return this;
    }
}
