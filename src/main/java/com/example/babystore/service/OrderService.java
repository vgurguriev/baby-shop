package com.example.babystore.service;

import com.example.babystore.model.dto.OrderDto;
import com.example.babystore.model.entity.CartItem;
import com.example.babystore.model.entity.Order;
import com.example.babystore.model.entity.Product;
import com.example.babystore.model.entity.User;
import com.example.babystore.repository.OrderRepository;
import com.example.babystore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    public OrderService(ModelMapper modelMapper, OrderRepository orderRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public void addOrder(OrderDto orderDto, User user) {

        List<Product> products = new ArrayList<>();

        for (CartItem product : user.getCart().getCartItems()) {
            products.add(product.getProduct());
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

        user.getCart().getCartItems().clear();
        this.userRepository.save(user);
    }
}
