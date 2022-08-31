package com.example.babystore.model.view;

public class BrandView {
    private Long id;

    private String name;

    public BrandView() {

    }

    public BrandView(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public BrandView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandView setName(String name) {
        this.name = name;
        return this;
    }
}
