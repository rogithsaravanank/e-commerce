package com.spring.e_commerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.e_commerce.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    
}
