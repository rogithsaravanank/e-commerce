package com.spring.e_commerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.e_commerce.entity.Product;
import com.spring.e_commerce.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public void loadProductsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Load the JSON file
            List<Product> products=objectMapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/products.json")),new TypeReference<List<Product>>() {});
            // Save products to the database
            productRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> getProductsById(Long id) {
        return productRepo.findById(id);
    }
    
}
