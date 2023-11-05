package com.example.ecommerce.user.mapper;

import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;
import com.example.ecommerce.user.model.entity.User;

public interface UserMapper {
    User registerRequestDTOToUser(RegisterRequestDTO requestDTO);
}
