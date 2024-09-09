package com.spring.e_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.spring.e_commerce.service.ProductService;
import com.spring.e_commerce.service.UserService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Load products from JSON
        productService.loadProductsFromJson();
        userService.loadUsersFromJson();
    }
}
