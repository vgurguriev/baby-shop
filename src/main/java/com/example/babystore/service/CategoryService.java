package com.example.babystore.service;

import com.example.babystore.model.entity.Category;
import com.example.babystore.model.entity.enums.CategoryEnum;
import com.example.babystore.model.view.CategoryView;
import com.example.babystore.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryView> getCategories() {

        return this.categoryRepository
                .findAll()
                .stream()
                .map(category -> new CategoryView()
                        .setId(category.getId())
                        .setName(CategoryEnum.valueOf(category.getName().name()).getValue())
                        .setBaseCategory(category.getBaseCategory()
                                .getBaseCategoryName().name()))
                .collect(Collectors.toList());
    }

}
