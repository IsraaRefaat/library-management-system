package com.esraa.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "borrowing_transaction")
public class BorrowTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "borrowed_by_user_id")
    private User borrowByUser;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    @PrePersist
    protected void onCreate() {
        this.borrowDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.returnDate = LocalDateTime.now();
    }

    private String status;
    private String notes;
}
