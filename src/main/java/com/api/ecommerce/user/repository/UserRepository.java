package com.api.ecommerce.user.repository;

import com.api.ecommerce.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
