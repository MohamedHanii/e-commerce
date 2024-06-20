package com.api.ecommerce.auth.service;


import com.api.ecommerce.auth.dto.CreateUserDTO;
import com.api.ecommerce.auth.dto.LoginUserDTO;


public interface AuthService  {
    void registerUser(CreateUserDTO createUserDTO);
    String authenticate(LoginUserDTO loginUserDTO);
}
