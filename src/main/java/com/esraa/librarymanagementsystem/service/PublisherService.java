package com.esraa.librarymanagementsystem.service;


import com.esraa.librarymanagementsystem.dto.PublisherDto;
import com.esraa.librarymanagementsystem.entity.Publisher;
import com.esraa.librarymanagementsystem.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceI{

    @Autowired
    private PublisherRepo publisherRepo;


    public ResponseEntity<?> getAllPublisher() {
        List<Publisher> publishers = publisherRepo.findAll();

        if (publishers.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

        return new ResponseEntity<>(publishers,HttpStatus.OK);
    }

    public ResponseEntity<?> addPublisher(Publisher publisher) {
        publisherRepo.save(publisher);
        return new ResponseEntity<>(publisher,HttpStatus.OK);
    }

    public ResponseEntity<?> updatePublisher(Integer id, PublisherDto publisher) {
        return publisherRepo.findById(id).map(publish -> {
            if (publisher.getName() != null) publish.setName(publish.getName());
            if (publisher.getEmail() != null) publish.setEmail(publisher.getEmail());
            if (publisher.getPhone() != null) publish.setPhone(publisher.getPhone());

            Publisher updatePublisher = publisherRepo.save(publish);
            return ResponseEntity.ok(updatePublisher);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    public ResponseEntity<?> deletePublisher(Integer id) {
        Optional<Publisher> publisher = publisherRepo.findById(id);

        if (publisher.isPresent()) {
            publisherRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Publisher deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publisher not found");
        }
    }
}
