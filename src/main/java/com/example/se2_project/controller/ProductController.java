package com.example.se2_project.controller;

import com.example.se2_project.model.Product;
import com.example.se2_project.repository.ProductRepository;
import com.example.se2_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryController categoryController;

    @GetMapping(value = "/list")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
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
