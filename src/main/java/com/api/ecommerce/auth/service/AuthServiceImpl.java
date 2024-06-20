package com.api.ecommerce.auth.service;

import com.api.ecommerce.auth.dto.CreateUserDTO;
import com.api.ecommerce.auth.dto.LoginUserDTO;
import com.api.ecommerce.config.JwtService;
import com.api.ecommerce.user.model.Role;
import com.api.ecommerce.user.model.User;
import com.api.ecommerce.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public void registerUser(CreateUserDTO createUserDTO) {
        User newUser = new User();
        newUser.setEmail(createUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        newUser.setFirstName(createUserDTO.getFirstName());
        newUser.setLastName(createUserDTO.getLastName());
        newUser.setRole(new Role(1,"user"));
        userRepository.save(newUser);

        String  jwtToken = jwtService.generateToken(newUser);

        System.out.println("token: " + jwtToken);
    }

    public String authenticate(LoginUserDTO loginUserDTO){
        //it will throw error if user not authenticated
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(),loginUserDTO.getPassword())
        );
        var user = userRepository.findByEmail(loginUserDTO.getEmail())
                .orElseThrow();

        return jwtService.generateToken(user);
    }
}
