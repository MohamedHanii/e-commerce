package com.example.ecommerce.authentication.service;

import com.example.ecommerce.authentication.model.DTO.AuthenticationRequestDTO;
import com.example.ecommerce.authentication.model.DTO.AuthenticationResponseDTO;
import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);

    AuthenticationResponseDTO register(RegisterRequestDTO request);
}
