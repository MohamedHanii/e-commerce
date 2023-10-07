package com.example.ecommerce.services.Interface;

import com.example.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

        User findByUsername(String username);

        User createUser(User user);
}
