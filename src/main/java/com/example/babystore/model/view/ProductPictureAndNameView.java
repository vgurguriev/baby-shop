package com.example.babystore.model.view;

public class ProductPictureAndNameView {
    private Long id;
    private String name;
    private String pictureUrl;

    public Long getId() {
        return id;
    }

    public ProductPictureAndNameView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductPictureAndNameView setName(String name) {
        this.name = name;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ProductPictureAndNameView setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
