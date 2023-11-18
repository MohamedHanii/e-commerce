package com.example.ecommerce.product.service;

import com.example.ecommerce.product.mapper.ProductMapper;
import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.product.repository.ProductRepository;
import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, UserRepository userRepository){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<ProductDTO> findAll(Long userId) {
        List<Product> products = productRepository.findUserProducts(userId);
        return productMapper.productsToProductDTOs(products);
    }

    @Override
    public ProductDTO findById(int id, Long userId) {
        Optional<Product> result = productRepository.findUserProduct(id,userId);
        Product dbProduct = null;
        if(result.isPresent()){
            dbProduct = result.get();
        }
        return productMapper.productToProductDTO(dbProduct);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, Long userId) {
        // to be fixed later
        Optional<User> user = userRepository.findById(userId.intValue());
        User dbUser = null;
        if(user.isEmpty()){
            return null;
        }
        dbUser = user.get();
        Product newProduct = productMapper.productDTOToProduct(productDTO);
        newProduct.setUser(dbUser);
        Product createdProduct = productRepository.save(newProduct);
        return productMapper.productToProductDTO(createdProduct);
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO productDTO, Long userId) {
        // Check if the product exists
        Product dbProduct = productRepository.findUserProduct(id,userId).orElse(null);
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
