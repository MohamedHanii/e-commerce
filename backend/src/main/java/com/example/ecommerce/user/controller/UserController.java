package com.example.ecommerce.user.controller;


import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.authentication.service.AuthenticationService;
import com.example.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService){
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    /**
     * Retrieves a list of all products.
     *
     * @return A list of all products in JSON format.
     */
    @GetMapping("{username}")
    public User getByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }


//
//    /**
//     * Updates product information by its unique identifier.
//     *
//     * @param id The unique identifier of the product.
//     * @param product The updated product information.
//     * @return The updated product in JSON format, or a 404 Not Found response if not found.
//     *          or 400 if the id not equals the product id in body
//     */
//    @PutMapping("{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
//        if(id != product.getId()){
//            return ResponseEntity.badRequest().build();
//        }
//        Product updated = productService.updateProduct(id, product);
//        if (updated != null) {
//            return ResponseEntity.ok(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    /**
//     * Deletes a product by its unique identifier.
//     *
//     * @param id The unique identifier of the product to be deleted.
//     * @return A 204 No Content response if the product was deleted successfully,
//     *         or a 404 Not Found response if the product was not found.
//     */
//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
//        Product dbProduct = productService.findById(id);
//
//        if(dbProduct == null){
//            return ResponseEntity.notFound().build();
//        }
//
//        productService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

}
