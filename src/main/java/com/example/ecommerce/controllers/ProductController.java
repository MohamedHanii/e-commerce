package com.example.ecommerce.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {


    /**
     * Retrieves all products.
     *
     * @return All products in JSON format.
     */
    @GetMapping("")
    public String getAllProducts(){
        return  "product list";
    }


    /**
     * Retrieves a product's information by id.
     *
     * @param id The unique identifier of the product.
     * @return product object in JSON format.
     */
    @GetMapping("{id}")
    public String getProduct(@PathVariable int id){
        return  "get product by id";
    }

    /**
     * create new product.
     *
     * @return the created product object in JSON format.
     */
    @PostMapping("")
    public String createProduct(){
        return  "product created";
    }

    /**
     * Retrieves a user's profile information by their user ID.
     *
     * @param id The unique identifier of the product.
     * @return updated product in JSON format.
     */
    @PutMapping("{id}")
    public String updateProduct(){
        return  "product created";
    }


    /**
     * Retrieves a user's profile information by their user ID.
     *
     * @param id The unique identifier of the product.
     * @return deleted product in JSON format.
     */
    @DeleteMapping("{id}")
    public String deleteProduct(){
        return  "product created";
    }


}
