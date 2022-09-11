package com.example.babystore.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "carts_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal subPrice;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Long getId() {
        return id;
    }

    public CartItem setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CartItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getSubPrice() {
        return subPrice;
    }

    public CartItem setSubPrice(BigDecimal subPrice) {
        this.subPrice = subPrice;
        return this;
    }
    public Product getProduct() {
        return product;
    }

    public CartItem setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public CartItem setCart(Cart cart) {
        this.cart = cart;
        return this;
    }
}
