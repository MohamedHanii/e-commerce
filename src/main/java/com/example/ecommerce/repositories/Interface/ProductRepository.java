package com.example.ecommerce.repositories.Interface;

import com.example.ecommerce.models.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Product findById(Integer id);
    List<Product> findAll();
    Product update(Product product);
    void delete(Integer id);

}
