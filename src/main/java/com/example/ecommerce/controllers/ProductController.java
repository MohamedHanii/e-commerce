package com.example.ecommerce.controllers;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.services.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /**
     * Retrieves all products.
     *
     * @return All products in JSON format.
     */
    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }


    /**
     * Retrieves a product's information by id.
     *
     * @param id The unique identifier of the product.
     * @return product object in JSON format.
     */
    @GetMapping("{id}")
    public Product getProduct(@PathVariable int id){
        Product product = productService.findById(id);

        if(product == null){
            throw new RuntimeException("Product id not found- "+ id);
        }

        return product;
    }

    /**
     * create new product.
     *
     * @return the created product object in JSON format.
     */
    @PostMapping("")
    public Product createProduct(@RequestBody Product product){
        product.setId(0);
        return  productService.save(product);
    }

    /**
     * Retrieves a user's profile information by their user ID.
     *
     * @param id The unique identifier of the product.
     * @return updated product in JSON format.
     */
    @PutMapping("{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        return  productService.Update(product);
    }


    /**
     * Retrieves a user's profile information by their user ID.
     *
     * @param id The unique identifier of the product.
     * @return deleted product in JSON format.
     */
    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id){
        Product dbProduct = productService.findById(id);

        if(dbProduct == null){
            throw new RuntimeException("Employee id not found - "+id);
        }

        productService.deleteById(id);

        return "Deleted employee id - "+id;
    }


}
