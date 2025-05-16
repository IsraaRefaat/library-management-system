package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.entity.Category;
import com.esraa.librarymanagementsystem.service.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceI categoryService;


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping
    public ResponseEntity<?> getCategory() {
        return categoryService.getCategories();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping("add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }



}
