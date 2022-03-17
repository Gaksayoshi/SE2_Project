package com.example.se2_project.controller;

import com.example.se2_project.model.Product;
import com.example.se2_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/Product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryController categoryController;

    @GetMapping(value = "/sort/AscName")
    public List<Product> sortProductAscByName(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @GetMapping(value = "/sort/DescName")
    public List<Product> sortProductDescByName(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    @GetMapping(value = "/sort/AscPrice")
    public List<Product> sortProductAscByPrice(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    @GetMapping(value = "/sort/DescPrice")
    public List<Product> sortProductDescByPrice(Model model){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }
}
