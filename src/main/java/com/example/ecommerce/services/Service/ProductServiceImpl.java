package com.example.ecommerce.services.Service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repositories.Interface.ProductRepository;
import com.example.ecommerce.services.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Product result = productRepository.findById(id);
        Product dbProduct = null;
        if(result!=null){
            dbProduct = result;
        }else{
            throw new RuntimeException("Didn't find employee id - "+id);
        }
        return dbProduct;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.delete(id);
    }
}
