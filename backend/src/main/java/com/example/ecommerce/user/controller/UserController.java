package com.example.ecommerce.user.controller;


import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.user.model.DTO.UserDTO;
import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.authentication.service.AuthenticationService;
import com.example.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("")
    public List<UserDTO> getAllUsers(){
        List<User> users =  userService.findAllUsers();
        // move to service or repository
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            UserDTO  userDTO  = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFirstname(user.getFirstname());
            userDTO.setLastname(user.getLastname());
            userDTO.setEmail(user.getEmail());
            userDTO.setUsername(user.getUsername());
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }


    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
        if(id != user.getId()){
            return ResponseEntity.badRequest().build();
        }
        User updated = userService.updateUser(id, user);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        User dbUser = userService.findById(id);

        if(dbUser == null){
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
