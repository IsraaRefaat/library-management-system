package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
