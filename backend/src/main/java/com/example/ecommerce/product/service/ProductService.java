package com.example.ecommerce.product.service;

import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll(Long userId);

    ProductDTO findById(int id, Long userId);

    ProductDTO createProduct(ProductDTO productDTO, Long userId);

    ProductDTO updateProduct(int id, ProductDTO productDTO, Long userId);

    void deleteById(int id);
}
