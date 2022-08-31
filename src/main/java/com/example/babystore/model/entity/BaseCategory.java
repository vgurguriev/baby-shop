package com.example.babystore.model.entity;

import com.example.babystore.model.entity.enums.BaseCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "base_categories")
public class BaseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BaseCategoryEnum baseCategoryName;

    public Long getId() {
        return id;
    }

    public BaseCategory setId(Long id) {
        this.id = id;
        return this;
    }

    public BaseCategoryEnum getBaseCategoryName() {
        return baseCategoryName;
    }

    public BaseCategory setBaseCategoryName(BaseCategoryEnum baseCategoryName) {
        this.baseCategoryName = baseCategoryName;
        return this;
    }
}
