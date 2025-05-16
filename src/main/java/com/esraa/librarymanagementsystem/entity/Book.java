package com.esraa.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"authors", "categories", "transactions"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "book")
public class Book {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String isbn;
    private int edition;
    @Column(name = "publication_year")
    private Integer publishYear;
    private String language;
    private String summary;
    private String cover_image_url;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<BorrowTransaction> transactions = new HashSet<>();



}
