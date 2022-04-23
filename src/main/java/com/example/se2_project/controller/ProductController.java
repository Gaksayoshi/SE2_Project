package com.example.se2_project.controller;

import com.example.se2_project.model.Product;
import com.example.se2_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryController categoryController;

    // List all product
    @GetMapping(value = "/list")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    // Get product by id
    @GetMapping(value = "/{id}")
    public Product getProductById(
            @PathVariable(value = "id") Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    // "POST" - create a new product
    @PostMapping(value = "/add")
    public Product addProduct(
            @RequestBody Product product) {
        return productRepository.save(product);
    }

    // "PUT" - update a product
    @PutMapping(value = "/add/{id}")
    public void updateProduct(
            @PathVariable(value = "id") Long id,
            @RequestBody Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
        }
    }

    // "DELETE" - delete a product
    @DeleteMapping(value="/delete/{id}")
    public void deleteProduct(
            @PathVariable(value = "id") Long id) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            productRepository.delete(product);
            System.out.println("Delete success!");
        }
    }

    //"Sort" Product list in ascending order via attribute "name"
    @GetMapping(value = "/sort/AscName")
    public List<Product> sortProductAscByName(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    //"Sort" Product list in descending order via attribute "name"
    @GetMapping(value = "/sort/DescName")
    public List<Product> sortProductDescByName(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    //"Sort" Product list in ascending order via attribute "price"
    @GetMapping(value = "/sort/AscPrice")
    public List<Product> sortProductAscByPrice(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    //"Sort" Product list in descending order via attribute "price"
    @GetMapping(value = "/sort/DescPrice")
    public List<Product> sortProductDescByPrice(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    //"Sort" Product list in ascending order via attribute "category"
    @GetMapping(value = "/sort/AscCate")
    public List<Product> sortProductAscByCate(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @GetMapping(value = "/sort/DescCate")
    public List<Product> sortProductDescByCate(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    @GetMapping
    public List<Product> filterProductByCategory(){
        return productRepository.findAll();
    }

}
