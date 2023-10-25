package com.example.ecommerce.user.repository;

import com.example.ecommerce.user.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Integer> {
}
