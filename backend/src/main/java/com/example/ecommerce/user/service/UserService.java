package com.example.ecommerce.user.service;

import com.example.ecommerce.user.model.entity.User;


public interface UserService {

        User findByUsername(String username);

        User createUser(User user);


}
