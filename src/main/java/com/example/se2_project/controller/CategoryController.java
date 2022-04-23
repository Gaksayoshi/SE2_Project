package com.example.se2_project.controller;

import com.example.se2_project.model.Category;
import com.example.se2_project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Change the web url to your desire
    // "GET" all category as List datatype
    @GetMapping(value = "/categories")
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }


    // Make changes everywhere else as well if needed
    // "GET" category by Id
    @GetMapping(value = "/categories/{id}")
    public Category getCategoryById(
            @PathVariable(value = "id") Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @PostMapping(value = "/categories/add")
    public Category addCategory(
            @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping(value = "/categories/add/{id}")
    public void updateCategory(
            @PathVariable(value = "id") Long id,
            @RequestBody Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            categoryRepository.save(category);
        }
    }

    @DeleteMapping(value = "/categories/delete/{id}")
    public void deleteCategory(
            @PathVariable(value = "id") Long id) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.findById(id).get();
            categoryRepository.delete(category);
        }
    }

}
