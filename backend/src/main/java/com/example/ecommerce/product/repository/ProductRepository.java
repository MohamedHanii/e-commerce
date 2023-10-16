package com.example.ecommerce.product.repository;

import com.example.ecommerce.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
