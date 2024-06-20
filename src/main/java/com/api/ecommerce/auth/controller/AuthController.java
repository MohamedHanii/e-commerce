package com.api.ecommerce.auth.controller;


import com.api.ecommerce.auth.dto.CreateUserDTO;
import com.api.ecommerce.auth.dto.LoginUserDTO;
import com.api.ecommerce.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        authService.registerUser(createUserDTO);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginUserDTO loginUserDTO){

    }


}
