package com.example.babystore.model.view;

import java.math.BigDecimal;

public class ProductView {

    private Long id;
    private String name;
    private BigDecimal price;
    private String pictureUrl;
    private String description;
    private String brand;
    private String color;

    public ProductView(Long id, String name, BigDecimal price,
                       String pictureUrl, String description, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.brand = brand;
    }

    public ProductView() {}

    public String getName() {
        return name;
    }

    public ProductView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ProductView setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public ProductView setColor(String color) {
        this.color = color;
        return this;
    }
}
