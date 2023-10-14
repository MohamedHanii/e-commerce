package com.example.ecommerce.user.service;

import com.example.ecommerce.user.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User createUser(User user);
}
