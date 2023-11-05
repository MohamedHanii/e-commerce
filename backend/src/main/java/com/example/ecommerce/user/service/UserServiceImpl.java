package com.example.ecommerce.user.service;

import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        // Check if the user exists
        User dbUser = userRepository.findById(id).orElse(null);
        if (dbUser == null) {
            return null; // or throw an exception
        }

        // Update the user's properties
        //TODO:Add Mapper layer
        dbUser.setFirstname(user.getFirstname());
        dbUser.setLastname(user.getLastname());
        dbUser.setEmail(user.getLastname());
        dbUser.setUsername(user.getUsername());
//        dbUser.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the updated product
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User dbUser = null;
        if(result.isPresent()){
            dbUser = result.get();
        }
        return dbUser;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
