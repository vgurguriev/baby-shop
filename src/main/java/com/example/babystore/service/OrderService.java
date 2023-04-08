package com.example.babystore.service;

import com.example.babystore.exception.NotFoundException;
import com.example.babystore.model.dto.OrderDto;
import com.example.babystore.model.entity.*;
import com.example.babystore.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public OrderService(ProductRepository productRepository,
                        OrderRepository orderRepository,
                        UserRepository userRepository,
                        CartItemRepository cartItemRepository,
                        CartRepository cartRepository,
                        CountryRepository countryRepository,
                        CityRepository cityRepository) {
        this.productRepository = productRepository;

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public void addOrder(OrderDto orderDto, User user) throws NotFoundException {

        List<Product> products = new ArrayList<>();

        for (CartItem cartItem : user.getCart().getCartItems()) {
            Product product = cartItem.getProduct();
            products.add(product);
            product.setSales(product.getSales() + 1);
            product.setCartItem(null);
            cartItem.setCart(null);
            cartItem.setProduct(null);
            this.cartItemRepository.save(cartItem);
            this.productRepository.save(product);
        }

        Order order = new Order()
                .setUser(user)
                .setFirstName(orderDto.getFirstName())
                .setLastName(orderDto.getLastName())
                .setEmail(orderDto.getEmail())
                .setProducts(products);
        this.orderRepository.save(order);

        products.forEach(product -> {
            product.getOrders().add(order);
            this.productRepository.save(product);
        });

        Country country = countryRepository.findById(orderDto.getCountryId())
                .orElseThrow(() -> new NotFoundException("Country not found."));
        City city = cityRepository.findById(orderDto.getCityId())
                .orElseThrow(() -> new NotFoundException("City not found."));
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        user.setAddress(address);

        user.getOrders().add(order);

        user.getCart().setTotalPrice(BigDecimal.ZERO);
        user.getCart().getCartItems().clear();
        userRepository.save(user);
    }
}
