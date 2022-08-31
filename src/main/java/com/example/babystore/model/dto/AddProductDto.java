package com.example.babystore.model.dto;

import com.example.babystore.model.entity.enums.ColorEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddProductDto {

    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotEmpty
    private String pictureUrl;

    @NotNull
    private ColorEnum color;

    @NotEmpty
    private String description;

    @NotNull
    private Long category;

    @NotNull
    private Long brand;

    public String getName() {
        return name;
    }

    public AddProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public AddProductDto setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public ColorEnum getColor() {
        return color;
    }

    public AddProductDto setColor(ColorEnum color) {
        this.color = color;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getCategory() {
        return category;
    }

    public AddProductDto setCategory(Long category) {
        this.category = category;
        return this;
    }

    public Long getBrand() {
        return brand;
    }

    public AddProductDto setBrand(Long brand) {
        this.brand = brand;
        return this;
    }
}
