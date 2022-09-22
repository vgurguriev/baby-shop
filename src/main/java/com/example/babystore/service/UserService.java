package com.example.babystore.service;

import com.example.babystore.model.dto.UserRegistrationDto;
import com.example.babystore.model.entity.Cart;
import com.example.babystore.model.entity.User;
import com.example.babystore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    public UserService(PasswordEncoder passwordEncoder, ModelMapper modelMapper,
                       UserRepository userRepository, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    public void registerAndLogin(UserRegistrationDto userRegistrationDto) {
        User userToRegister = this.modelMapper.map(userRegistrationDto, User.class)
                .setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));


        userToRegister.setCart(new Cart()
                .setUser(userToRegister)
                .setTotalPrice(BigDecimal.ZERO)
                .setCartItems(new HashSet<>()));
        this.userRepository.save(userToRegister);
        login(userToRegister);

    }

    private void login(User user) {
        UserDetails userDetails =
                this.userDetailsService.loadUserByUsername(user.getUsername());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    public User findByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .orElseThrow();
    }
}
