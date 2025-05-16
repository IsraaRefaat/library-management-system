package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookServiceI {

     ResponseEntity<List<Book>> getAllBooks();

     ResponseEntity<Book> getBook(int id);

    ResponseEntity<List<Book>> search(String keyword);


     ResponseEntity<Book> add(Book inputBook);


     ResponseEntity<?> update(int id, Book bookInput);


     ResponseEntity<String> deleteBook(int id);


}
