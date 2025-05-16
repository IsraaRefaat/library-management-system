package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.AuthorDTO;
import com.esraa.librarymanagementsystem.entity.Author;
import org.springframework.http.ResponseEntity;


public interface AuthorServiceI {

     ResponseEntity<?> getAllAuthors();

     ResponseEntity<?> addAuthor(Author author);

     ResponseEntity<?> updateAuthor(Integer id, AuthorDTO author);

     ResponseEntity<?> deleteAuthor(Integer id);

}
