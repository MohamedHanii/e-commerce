package com.example.ecommerce.user.controller;


import com.example.ecommerce.user.model.entity.User;
import com.example.ecommerce.authentication.service.AuthenticationService;
import com.example.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Retrieves a list of all products.
     *
     * @return A list of all products in JSON format.
     */


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
