package com.example.ecommerce.services.Interface;

import com.example.ecommerce.controllers.AuthenticationRequest;
import com.example.ecommerce.controllers.AuthenticationResponse;
import com.example.ecommerce.controllers.RegisterRequest;
import com.example.ecommerce.model.User;


public interface UserService {

        User findByUsername(String username);

        User createUser(User user);

        AuthenticationResponse authenticate(AuthenticationRequest request);

        AuthenticationResponse register(RegisterRequest request);
}
