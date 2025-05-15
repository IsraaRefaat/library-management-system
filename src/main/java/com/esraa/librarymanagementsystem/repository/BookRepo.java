package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("""
    SELECT DISTINCT b FROM Book b
    LEFT JOIN b.categories c
    LEFT JOIN b.authors a
    WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<Book> searchBooks(@Param("keyword") String keyword);

}
