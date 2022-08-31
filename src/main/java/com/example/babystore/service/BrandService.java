package com.example.babystore.service;

import com.example.babystore.model.entity.enums.BrandEnum;
import com.example.babystore.model.view.BrandView;
import com.example.babystore.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandView> getBrands() {
        return this.brandRepository
                .findAll()
                .stream()
                .map(brand -> new BrandView()
                        .setId(brand.getId())
                        .setName(BrandEnum.valueOf(brand.getName().name()).getValue()))
                .collect(Collectors.toList());
    }
}
