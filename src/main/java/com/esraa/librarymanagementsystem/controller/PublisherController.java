package com.esraa.librarymanagementsystem.controller;


import com.esraa.librarymanagementsystem.dto.PublisherDto;
import com.esraa.librarymanagementsystem.entity.Publisher;
import com.esraa.librarymanagementsystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @GetMapping
    public ResponseEntity<?> getPublishers() {
        return publisherService.getAllPublisher();
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PostMapping
    public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }


    @PreAuthorize("hasRole('ADMIM') or hasRole('LIBRARIAN')")
    @PatchMapping("update/{id}")
    public ResponseEntity<?> updatePublisher(@PathVariable Integer id,@RequestBody PublisherDto publisher) {
        return publisherService.updatePublisher(id, publisher);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Integer id) {
        return publisherService.deletePublisher(id);
    }

}
