package com.spring.e_commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.e_commerce.entity.CartItem;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItem,Long>{
    
}
