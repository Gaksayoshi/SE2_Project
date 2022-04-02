package com.example.se2_project.controller;

import com.example.se2_project.model.Product;
import com.example.se2_project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    // "GET" - listing all products (in JSON format)
    @GetMapping(value = "/products")
    public List<Product> getAllProduct() {
        List<Product> productList = productRepo.findAll();
        return productList;
    }

    // "GET" by id
    @GetMapping(value = "/products/{id}")
    public Product getProductById(
            @PathVariable(value = "id") Long id) {
        Product product = productRepo.findById(id).get();
        return product;
    }

    // "POST" - create a new product
    @PostMapping(value = "/products/add")
    public Product addProduct(
            @RequestBody Product product) {
        return productRepo.save(product);
    }

    // "PUT" - update a product
    @PutMapping(value = "/products/add/{id}")
    public void updateProduct(
            @PathVariable(value = "id") Long id,
            @RequestBody Product product) {
        if (productRepo.existsById(id)) {
            product.setId(id);
            productRepo.save(product);
        }
    }

    // "DELETE" - delete a product
    @DeleteMapping(value="/products/delete/{id}")
    public void deleteProduct(
            @PathVariable(value = "id") Long id) {
        if (productRepo.existsById(id)) {
            Product product = productRepo.findById(id).get();
            productRepo.delete(product);
        }
    }

}
