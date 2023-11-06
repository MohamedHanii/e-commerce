package com.example.ecommerce.product.service;

import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO findById(int id);

    Product createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(int id, ProductDTO productDTO);

    void deleteById(int id);
}
