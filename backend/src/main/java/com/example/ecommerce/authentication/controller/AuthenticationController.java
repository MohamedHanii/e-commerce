package com.example.ecommerce.authentication.controller;

import com.example.ecommerce.authentication.model.DTO.AuthenticationRequestDTO;
import com.example.ecommerce.authentication.model.DTO.AuthenticationResponseDTO;
import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;
import com.example.ecommerce.authentication.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    /**
     * Creates a new user.
     *
     * @param request The user object to be created.
     * @return The created user object in JSON format with a 201 Created response status.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
}
