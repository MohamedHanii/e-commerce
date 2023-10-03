package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.services.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * Retrieves a list of all products.
     *
     * @return A list of all products in JSON format.
     */
    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }


    /**
     * Retrieves product information by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The product object in JSON format, or a 404 Not Found response if not found.
     */
    @GetMapping("{id}")
    public  ResponseEntity<Product> getProduct(@PathVariable int id){
        Product product = productService.findById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    /**
     * Creates a new product.
     *
     * @param product The product object to be created.
     * @return The created product object in JSON format with a 201 Created response status.
     */
    @PostMapping("")
    public  ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = productService.createProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    /**
     * Updates product information by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @param product The updated product information.
     * @return The updated product in JSON format, or a 404 Not Found response if not found.
     */
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        Product updated = productService.updateProduct(id, product);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /**
     * Deletes a product by its unique identifier.
     *
     * @param id The unique identifier of the product to be deleted.
     * @return A 204 No Content response if the product was deleted successfully,
     *         or a 404 Not Found response if the product was not found.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        Product dbProduct = productService.findById(id);

        if(dbProduct == null){
            return ResponseEntity.notFound().build();
        }

        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
