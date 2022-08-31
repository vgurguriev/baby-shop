package com.example.babystore.model.view;

public class CategoryView {
    private Long id;
    private String name;
    private String baseCategory;

    public CategoryView(Long id, String name, String baseCategory) {
        this.id = id;
        this.name = name;
        this.baseCategory = baseCategory;
    }

    public CategoryView() {}

    public String getName() {
        return name;
    }

    public CategoryView setName(String name) {
        this.name = name;
        return this;
    }

    public String getBaseCategory() {
        return baseCategory;
    }

    public CategoryView setBaseCategory(String baseCategory) {
        this.baseCategory = baseCategory;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CategoryView setId(Long id) {
        this.id = id;
        return this;
    }
}
