package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.entity.Book;
import com.esraa.librarymanagementsystem.service.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookServiceI bookService;

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping("search/{keyword}")
    public ResponseEntity<List<Book>> searchBooks(@PathVariable("keyword") String keyword) {
        return bookService.search(keyword);
    }

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping("add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id , @RequestBody Book book) {
        return bookService.update(id , book);
    }

    @PreAuthorize("hasRole('ADMIM')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

}
