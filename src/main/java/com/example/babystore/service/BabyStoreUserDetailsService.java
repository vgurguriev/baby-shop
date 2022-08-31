package com.example.babystore.service;

import com.example.babystore.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class BabyStoreUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BabyStoreUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getRole()
                                .stream()
                                .map(r -> new SimpleGrantedAuthority(
                                        "ROLE_" + r.getRole().name()
                                )).collect(Collectors.toList())
                )).orElseThrow(() -> new UsernameNotFoundException(username +
                        "was not found"));
    }
}
