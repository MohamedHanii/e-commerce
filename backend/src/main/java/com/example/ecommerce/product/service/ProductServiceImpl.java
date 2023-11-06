package com.example.ecommerce.product.service;

import com.example.ecommerce.product.mapper.ProductMapper;
import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.productsToProductDTOs(products);
    }

    @Override
    public ProductDTO findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product dbProduct = null;
        if(result.isPresent()){
            dbProduct = result.get();
        }
        return productMapper.productToProductDTO(dbProduct);
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product newProduct = productMapper.productDTOToProduct(productDTO);
        return productRepository.save(newProduct);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        // Check if the product exists
        Product dbProduct = productRepository.findById(id).orElse(null);
        if (dbProduct == null) {
            return null; // or throw an exception
        }

        // Update the product's properties
        productMapper.updateProductFromDTO(productDTO,dbProduct);


        Product createdProduct = productRepository.save(dbProduct);
        // Save the updated product
        return productMapper.productToProductDTO(createdProduct);
    }


    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
