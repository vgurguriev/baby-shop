package com.example.babystore.model.entity;

import com.example.babystore.model.entity.enums.ColorEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ColorEnum color;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer sales;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private User createdBy;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private CartItem cartItem;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
    )
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Product setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public ColorEnum getColor() {
        return color;
    }

    public Product setColor(ColorEnum color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Product setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Product setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public Product setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
        return this;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Product setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Integer getSales() {
        return sales;
    }

    public Product setSales(Integer sales) {
        this.sales = sales;
        return this;
    }
}
