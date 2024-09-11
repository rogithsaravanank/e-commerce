package com.spring.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.e_commerce.entity.Cart;
import com.spring.e_commerce.repo.CartRepo;

@Service
public class CartService {
    
    @Autowired
    CartRepo cartRepo;

    public Cart addProductToCart(Cart cart) {
       return cartRepo.save(cart);
    }
    
}
