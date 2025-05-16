package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Category;
import com.esraa.librarymanagementsystem.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    public ResponseEntity<?> getCategories() {
        List<Category> categories = categoryRepo.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    public ResponseEntity<Category> addCategory(Category category) {

        if (category.getParent() != null && category.getParent().getId() != null) {
            Category parent = categoryRepo.findById(category.getParent().getId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
        }

        Category savedCategory = categoryRepo.save(category);

        return ResponseEntity.ok(savedCategory);
    }

}
