package com.example.ecommerce.services.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repositories.Interface.ProductRepository;
import com.example.ecommerce.services.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product dbProduct = null;
        if(result.isPresent()){
            dbProduct = result.get();
        }
        return dbProduct;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        // Check if the product exists
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null; // or throw an exception
        }

        // Update the product's properties
        //TODO:Add Mapper layer
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());


        // Save the updated product
        return productRepository.save(existingProduct);
    }


    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
