package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.entity.Author;
import com.esraa.librarymanagementsystem.entity.Publisher;
import com.esraa.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping("author")
    public ResponseEntity<?> getAuthors() {
        return authorService.getAllAuthors();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping("add")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PutMapping("update")
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        return authorService.deleteAuthor(id);
    }



}
