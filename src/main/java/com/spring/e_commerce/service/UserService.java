package com.spring.e_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.e_commerce.entity.User;
import com.spring.e_commerce.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }

    public List<User> getUser() {
        return userRepo.findAll();
    }
    
}
