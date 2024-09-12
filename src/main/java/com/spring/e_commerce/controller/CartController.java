package com.spring.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.e_commerce.entity.Cart;
import com.spring.e_commerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> addProductToCart(@RequestBody Cart cart){
       Cart savedCart= cartService.addProductToCart(cart);
        // return ResponseEntity.status(201).body("Product added To Cart");
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getProductFromCart(){
        return cartService.getProductFromCart();
        // return ResponseEntity.status(201).body("Product added To Cart");
    }

}
