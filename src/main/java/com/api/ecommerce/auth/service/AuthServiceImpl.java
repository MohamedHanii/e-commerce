package com.api.ecommerce.auth.service;

import com.api.ecommerce.auth.dto.CreateUserDTO;
import com.api.ecommerce.user.model.Role;
import com.api.ecommerce.user.model.User;
import com.api.ecommerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    @Override
    public void registerUser(CreateUserDTO createUserDTO) {
        User newUser = new User();

        newUser.setEmail(createUserDTO.getEmail());
        newUser.setPassword(createUserDTO.getPassword());
        newUser.setFirstName(createUserDTO.getFirstName());
        newUser.setLastName(createUserDTO.getLastName());
        newUser.setRole(new Role(1,"user"));
        userRepository.save(newUser);
    }
}
