package com.spring.e_commerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.e_commerce.entity.Product;
import com.spring.e_commerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts(){
    return productService.getProducts();
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Product> getProductsById(@PathVariable Long id ){
    return productService.getProductsById(id);
    }


}
