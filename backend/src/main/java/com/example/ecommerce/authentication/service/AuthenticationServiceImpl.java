package com.example.ecommerce.authentication.service;

import com.example.ecommerce.config.JwtService;
import com.example.ecommerce.authentication.model.DTO.AuthenticationRequestDTO;
import com.example.ecommerce.authentication.model.DTO.AuthenticationResponseDTO;
import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;
import com.example.ecommerce.user.model.entity.Role;
import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.user.repository.RoleRepository;
import com.example.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    

    @Override
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponseDTO(jwtToken);
    }

    @Override
    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
//        Role role  = roleRepository.getReferenceById(request.getRoleId());
        User user = new User(request.getUsername(),passwordEncoder.encode(request.getPassword()), request.getFirstName(),new Role(request.getRoleId()));
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponseDTO(jwtToken);
    }



}
