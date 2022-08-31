package com.example.babystore.model.entity;

import com.example.babystore.model.entity.enums.BrandEnum;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private BrandEnum name;

    public Long getId() {
        return id;
    }

    public Brand setId(Long id) {
        this.id = id;
        return this;
    }

    public BrandEnum getName() {
        return name;
    }

    public Brand setName(BrandEnum name) {
        this.name = name;
        return this;
    }
}
