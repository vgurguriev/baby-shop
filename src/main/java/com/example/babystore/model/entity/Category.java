package com.example.babystore.model.entity;

import com.example.babystore.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(    nullable = false)
    private CategoryEnum name;

    @ManyToOne()
    private BaseCategory baseCategory;

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public BaseCategory getBaseCategory() {
        return baseCategory;
    }

    public Category setBaseCategory(BaseCategory baseCategory) {
        this.baseCategory = baseCategory;
        return this;
    }
}
