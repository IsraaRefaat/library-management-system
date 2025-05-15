package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Book;
import com.esraa.librarymanagementsystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Book> getBook(int id) {
        return bookRepo.findById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<Book>> search(String keyword) {
        List<Book> books = bookRepo.searchBooks(keyword);
        if(books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK); // Return empty list instead of NOT_FOUND
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    public ResponseEntity<Book> add(Book book) {
        bookRepo.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<Book> update(int id , Book book) {
        return bookRepo.findById(id).map(existingBook -> {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthors(book.getAuthors());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setPublishYear(book.getPublishYear());
            existingBook.setCategories(book.getCategories());
            existingBook.setLanguage(book.getLanguage());
            existingBook.setEdition(book.getEdition());
            existingBook.setCreatedAt(book.getCreatedAt());
            existingBook.setUpdatedAt(book.getUpdatedAt());
            existingBook.setCover_image_url(book.getCover_image_url());
            existingBook.setSummary(book.getSummary());
            existingBook.setTransactions(book.getTransactions());

            Book savedBook = bookRepo.save(existingBook);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<String> deleteBook(int id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>("The book deleted successfully",HttpStatus.OK);
    }

}
