package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.AuthorDTO;
import com.esraa.librarymanagementsystem.entity.Author;
import com.esraa.librarymanagementsystem.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceI{

    @Autowired
    private AuthorRepo authorRepo;


    public ResponseEntity<?> getAllAuthors() {
        List<Author> authors = authorRepo.findAll();

        if (authors.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

        return new ResponseEntity<>(authors,HttpStatus.OK);
    }

    public ResponseEntity<?> addAuthor(Author author) {
        authorRepo.save(author);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }

    public ResponseEntity<?> updateAuthor(Integer id, AuthorDTO author) {
        return authorRepo.findById(id).map(auth -> {
            if (author.getName() != null) auth.setName(author.getName());
            if (author.getEmail() != null) auth.setEmail(author.getEmail());
            if (author.getPhone() != null) auth.setPhone(author.getPhone());

            Author updatedAuthor = authorRepo.save(auth);
            return ResponseEntity.ok(updatedAuthor);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    public ResponseEntity<?> deleteAuthor(Integer id) {
        Optional<Author> author = authorRepo.findById(id);

        if (author.isPresent()) {
            authorRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Author deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
    }
}
