package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.entity.Author;
import com.esraa.librarymanagementsystem.entity.Book;
import com.esraa.librarymanagementsystem.entity.Category;
import com.esraa.librarymanagementsystem.entity.Publisher;
import com.esraa.librarymanagementsystem.repository.AuthorRepo;
import com.esraa.librarymanagementsystem.repository.BookRepo;
import com.esraa.librarymanagementsystem.repository.CategoryRepo;
import com.esraa.librarymanagementsystem.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;

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


    public ResponseEntity<Book> add(Book inputBook) {

        Publisher publisher = publisherRepo.findById(inputBook.getPublisher().getId())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        Set<Author> authors = inputBook.getAuthors().stream()
                .map(a -> authorRepo.findById(a.getId())
                        .orElseThrow(() -> new RuntimeException("Author not found")))
                .collect(Collectors.toSet());

        Set<Category> categories = inputBook.getCategories().stream()
                .map(c -> categoryRepo.findById(c.getId())
                        .orElseThrow(() -> new RuntimeException("Category not found")))
                .collect(Collectors.toSet());

        Book book = new Book();
        book.setTitle(inputBook.getTitle());
        book.setIsbn(inputBook.getIsbn());
        book.setEdition(inputBook.getEdition());
        book.setPublishYear(inputBook.getPublishYear());
        book.setLanguage(inputBook.getLanguage());
        book.setSummary(inputBook.getSummary());
        book.setCover_image_url(inputBook.getCover_image_url());
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setCategories(categories);

        bookRepo.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> update(int id, Book bookInput) {
        return bookRepo.findById(id).map(existingBook -> {
            // Load related entities properly
            Publisher publisher = publisherRepo.findById(bookInput.getPublisher().getId())
                    .orElseThrow(() -> new RuntimeException("Publisher not found"));
            Set<Author> authors = bookInput.getAuthors().stream()
                    .map(a -> authorRepo.findById(a.getId())
                            .orElseThrow(() -> new RuntimeException("Author not found")))
                    .collect(Collectors.toSet());
            Set<Category> categories = bookInput.getCategories().stream()
                    .map(c -> categoryRepo.findById(c.getId())
                            .orElseThrow(() -> new RuntimeException("Category not found")))
                    .collect(Collectors.toSet());

            // Update fields
            existingBook.setTitle(bookInput.getTitle());
            existingBook.setIsbn(bookInput.getIsbn());
            existingBook.setEdition(bookInput.getEdition());
            existingBook.setPublishYear(bookInput.getPublishYear());
            existingBook.setLanguage(bookInput.getLanguage());
            existingBook.setSummary(bookInput.getSummary());
            existingBook.setCover_image_url(bookInput.getCover_image_url());

            existingBook.setPublisher(publisher);
            existingBook.setAuthors(authors);
            existingBook.setCategories(categories);

            bookRepo.save(existingBook);
            return new ResponseEntity<>(HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    public ResponseEntity<String> deleteBook(int id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>("The book deleted successfully",HttpStatus.OK);
    }

}
