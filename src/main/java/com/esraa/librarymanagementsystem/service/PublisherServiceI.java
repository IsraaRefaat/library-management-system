package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.PublisherDto;
import com.esraa.librarymanagementsystem.entity.Publisher;
import org.springframework.http.ResponseEntity;

public interface PublisherServiceI {

    ResponseEntity<?> getAllPublisher();

    ResponseEntity<?> addPublisher(Publisher publisher);

    ResponseEntity<?> updatePublisher(Integer id, PublisherDto publisher);

    ResponseEntity<?> deletePublisher(Integer id);

}
