package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Author;
import com.esraa.librarymanagementsystem.entity.Publisher;
import com.esraa.librarymanagementsystem.repository.AuthorRepo;
import com.esraa.librarymanagementsystem.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

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

    public ResponseEntity<?> updateAuthor(Author author) {
        Optional<Author> existAuthor = authorRepo.findById(author.getId());

        if (existAuthor.isPresent()) {
            Author auth = new Author();
            auth.setName(author.getName());
            auth.setEmail(author.getEmail());
            auth.setPhone(author.getPhone());
            auth.setBooks(author.getBooks());

            authorRepo.save(auth);

            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
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
