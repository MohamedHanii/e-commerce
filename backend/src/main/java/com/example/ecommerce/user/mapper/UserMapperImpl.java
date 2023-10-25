package com.example.ecommerce.user.mapper;

import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;
import com.example.ecommerce.user.model.entity.Role;
import com.example.ecommerce.user.model.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapperImpl implements UserMapper {


    @Override
    public User registerRequestDTOToUser(RegisterRequestDTO requestDTO) {
        User user = new User();
        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());
        user.setFirstname(requestDTO.getFirstName());
        user.setLastname(requestDTO.getLastName());
        user.setRole(new Role(requestDTO.getRoleId()));

        return user;
    }
}
