package com.example.babystore.service;

import com.example.babystore.model.dto.AddProductDto;
import com.example.babystore.model.entity.Brand;
import com.example.babystore.model.entity.Category;
import com.example.babystore.model.entity.Product;
import com.example.babystore.model.entity.User;
import com.example.babystore.model.view.OfferView;
import com.example.babystore.repository.BrandRepository;
import com.example.babystore.repository.CategoryRepository;
import com.example.babystore.repository.ProductRepository;
import com.example.babystore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    public ProductService(UserRepository userRepository, CategoryRepository categoryRepository, BrandRepository brandRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public void addProduct(AddProductDto addProductDto, UserDetails userDetails) {
        User user =  this.userRepository
                .findByUsername(userDetails.getUsername())
                .orElseThrow();

        Category category = this.categoryRepository
                .findById(addProductDto.getCategory())
                .orElseThrow();

        Brand brand = this.brandRepository
                .findById(addProductDto.getBrand())
                .orElseThrow();

        Product newProduct = this.modelMapper
                .map(addProductDto, Product.class);

        newProduct.setCreatedBy(user);
        newProduct.setCategory(category);
        newProduct.setBrand(brand);

        this.productRepository.save(newProduct);
    }

    public List<OfferView> getAllProducts() {
        return this.productRepository
                .findAll()
                .stream()
                .map(product -> this.modelMapper
                        .map(product, OfferView.class))
                .collect(Collectors.toList());
    }

    public List<OfferView> getAllProducts(Long id) {
        return this.productRepository
                .findAllByCategoryId(id)
                .stream()
                .map(product -> this.modelMapper
                        .map(product, OfferView.class))
                .collect(Collectors.toList());
    }
}
