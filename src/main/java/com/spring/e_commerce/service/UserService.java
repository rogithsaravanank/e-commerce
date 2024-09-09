package com.spring.e_commerce.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public void loadUsersFromJson() {
        ObjectMapper objMapper=new ObjectMapper();
        try{
        List<User> users=objMapper.readValue(Files.readAllBytes(Paths.get("src/main/resources/users.json")),new TypeReference<List<User>>() {} );
        userRepo.saveAll(users);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
