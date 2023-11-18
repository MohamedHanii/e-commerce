package com.example.ecommerce.product.repository;

import com.example.ecommerce.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value="SELECT p FROM Product p where p.user.id=:userId")
    List<Product> findUserProducts(@Param("userId") Long userId);

    @Query(value="SELECT p FROM Product p where p.id=:id AND p.user.id=:userId")
    Optional<Product> findUserProduct(int id,@Param("userId") Long userId);
}
