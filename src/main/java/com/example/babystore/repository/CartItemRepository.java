package com.example.babystore.repository;

import com.example.babystore.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByProductId(Long id);
    void deleteAllByCartId(Long id);
}
