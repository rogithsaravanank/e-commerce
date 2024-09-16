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

import com.spring.e_commerce.entity.Order;
import com.spring.e_commerce.service.OrderService;


@RestController
@RequestMapping("/api")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/checkout",consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Order> createOrder(@RequestBody Order order){
       Order saveOrder= orderService.createOrder(order);
        // return ResponseEntity.status(201).body("Order Created ");
        return new ResponseEntity<>(saveOrder,HttpStatus.CREATED);
    }

    @GetMapping(value="/orders",produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Order>> getOrder(){
        // return orderService.getOrder();
        return ResponseEntity.ok(orderService.getOrder());
    }
}
