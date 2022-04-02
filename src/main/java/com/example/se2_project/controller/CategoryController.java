package com.example.se2_project.controller;

import com.example.se2_project.model.Category;
import com.example.se2_project.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;

    // Change the web url to your desire
    // "GET" all category as List datatype
    @GetMapping(value = "/categories")
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList;
    }


    // Make changes everywhere else as well if needed
    // "GET" category by Id
    @GetMapping(value = "/categories/{id}")
    public Category getCategoryById(
            @PathVariable(value = "id") Long id) {
        Category category = categoryRepo.findById(id).get();
        return category;
    }

    @PostMapping(value = "/categories/add")
    public Category addCategory(
            @RequestBody Category category) {
        return categoryRepo.save(category);
    }

    @PutMapping(value = "/categories/add/{id}")
    public void updateCategory(
            @PathVariable(value = "id") Long id,
            @RequestBody Category category) {
        if (categoryRepo.existsById(id)) {
            category.setId(id);
            categoryRepo.save(category);
        }
    }

    @DeleteMapping(value = "/categories/delete/{id}")
    public void deleteCategory(
            @PathVariable(value = "id") Long id) {
        if (categoryRepo.existsById(id)) {
            Category category = categoryRepo.findById(id).get();
            categoryRepo.delete(category);
        }
    }
}
