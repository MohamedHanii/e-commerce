package com.example.ecommerce.services.Interface;

import com.example.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);

    void deleteById(int id);
}