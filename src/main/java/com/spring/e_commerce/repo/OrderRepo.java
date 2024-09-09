package com.spring.e_commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.e_commerce.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{
    
}
