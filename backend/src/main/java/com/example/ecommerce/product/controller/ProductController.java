package com.example.ecommerce.product.controller;

import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.product.service.ProductService;
import com.example.ecommerce.user.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

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
    @PreAuthorize("hasRole('MANAGER')")
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
     *          or 400 if the id not equals the product id in body
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        if(id != product.getId()){
            return ResponseEntity.badRequest().build();
        }
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
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        Product dbProduct = productService.findById(id);

        if(dbProduct == null){
            return ResponseEntity.notFound().build();
        }

        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
