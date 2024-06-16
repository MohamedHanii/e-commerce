package com.example.ecommerce.product.service;

import com.example.ecommerce.product.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteById(int id);
}
