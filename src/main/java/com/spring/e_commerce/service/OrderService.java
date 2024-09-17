package com.spring.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.e_commerce.entity.Order;
import com.spring.e_commerce.entity.OrderItem;
import com.spring.e_commerce.entity.Product;
import com.spring.e_commerce.repo.OrderItemsRepo;
import com.spring.e_commerce.repo.OrderRepo;
import com.spring.e_commerce.repo.ProductRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderItemsRepo orderItemsRepo;

    @Autowired
    ProductRepo productRepo;

    public Order createOrder(Order order) {

        Order savedorder= orderRepo.save(order);

        for(OrderItem items:order.getOrderItems()){
             Optional<Product> productOpt = productRepo.findById(items.getProduct().getId());

            if (!productOpt.isPresent()) {
                throw new IllegalStateException("Product with ID " + items.getProduct().getId() + " does not exist.");
            }

            // Set the product and associate the CartItem with the saved Cart
            items.setProduct(productOpt.get());
           
            
        items.setOrder(savedorder);
        orderItemsRepo.save(items);
        }

        return savedorder;
    }

    public List<Order> getOrder() {
       return orderRepo.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }
    
}
