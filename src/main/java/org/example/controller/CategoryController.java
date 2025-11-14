package org.example.controller;

import org.example.entities.Category;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return service.create(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return "Category deleted";
    }
}
