package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryServiceI {

    ResponseEntity<?> getCategories();

    ResponseEntity<Category> addCategory(Category category);


}
