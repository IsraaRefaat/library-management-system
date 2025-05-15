package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.entity.Category;
import com.esraa.librarymanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping("category")
    public ResponseEntity<?> getCategory() {
        return categoryService.getCategories();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping("add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }



}
