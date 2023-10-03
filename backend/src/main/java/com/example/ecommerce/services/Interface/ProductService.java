package com.example.ecommerce.services.Interface;

import com.example.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteById(int id);
}
