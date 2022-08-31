package com.example.babystore.model.view;

import java.math.BigDecimal;

public class OfferView {

    private Long id;
    private String name;
    private BigDecimal price;
    private String pictureUrl;
    private String description;

    public String getName() {
        return name;
    }

    public OfferView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public OfferView setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferView setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferView setId(Long id) {
        this.id = id;
        return this;
    }
}
