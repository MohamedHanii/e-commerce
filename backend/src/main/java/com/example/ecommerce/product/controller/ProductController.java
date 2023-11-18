package com.example.ecommerce.product.controller;

import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.product.service.ProductService;
import com.example.ecommerce.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final SecurityUtils securityUtils;

    @Autowired
    public ProductController(ProductService productService,SecurityUtils securityUtils){
        this.productService = productService;
        this.securityUtils = securityUtils;
    }


    /**
     * Retrieves a list of all products.
     *
     * @return A list of all products in JSON format.
     */
    @GetMapping("")
    public List<ProductDTO> getAllProducts(){
        Long userId = securityUtils.getCurrentUserId();
        return productService.findAll(userId);
    }


    /**
     * Retrieves product information by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @return The product object in JSON format, or a 404 Not Found response if not found.
     */
    @GetMapping("{id}")
    public  ResponseEntity<ProductDTO> getProduct(@PathVariable int id){
        Long userId = securityUtils.getCurrentUserId();
        ProductDTO product = productService.findById(id,userId);
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
    public  ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        Long userId = securityUtils.getCurrentUserId();
        ProductDTO newProduct = productService.createProduct(product,userId);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    /**
     * Updates product information by its unique identifier.
     *
     * @param id The unique identifier of the product.
     * @param productDTO The updated product information.
     * @return The updated product in JSON format, or a 404 Not Found response if not found.
     *          or 400 if the id not equals the product id in body
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO){
        Long userId = securityUtils.getCurrentUserId();
        if(id != productDTO.getProductId()){
            return ResponseEntity.badRequest().build();
        }

        ProductDTO updated = productService.updateProduct(id, productDTO,userId);

        if (updated != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updated);
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
        Long userId = securityUtils.getCurrentUserId();

        ProductDTO dbProduct = productService.findById(id, userId);

        if(dbProduct == null){
            return ResponseEntity.notFound().build();
        }

        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
