package com.example.babystore.service;

import com.example.babystore.model.dto.OrderDto;
import com.example.babystore.model.entity.*;
import com.example.babystore.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public OrderService(ProductRepository productRepository,
                        OrderRepository orderRepository,
                        UserRepository userRepository, CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    public void addOrder(OrderDto orderDto, User user) {

        List<Product> products = new ArrayList<>();

        for (CartItem cartItem : user.getCart().getCartItems()) {
            products.add(cartItem.getProduct());
            Product product = cartItem.getProduct();
            product.setSales(product.getSales() + 1);
            this.productRepository.save(product);
        }

        Order order = new Order()
                .setUser(user)
                .setFirstName(orderDto.getFirstName())
                .setLastName(orderDto.getLastName())
                .setEmail(orderDto.getEmail())
                .setProducts(products);
        this.orderRepository.save(order);

        user.setCity(orderDto.getCity())
                .setAddress(orderDto.getAddress())
                .setCountry(orderDto.getCountry());


    }
}
