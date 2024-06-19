package com.api.ecommerce.auth.service;


import com.api.ecommerce.auth.dto.CreateUserDTO;


public interface AuthService  {
    void registerUser(CreateUserDTO createUserDTO);
}
