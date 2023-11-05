package com.example.ecommerce.user.service;

import com.example.ecommerce.user.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> findAllUsers();
    User createUser(User user);

    User updateUser(int id, User user);

    User findById(int id);

    void deleteById(int id);
}
