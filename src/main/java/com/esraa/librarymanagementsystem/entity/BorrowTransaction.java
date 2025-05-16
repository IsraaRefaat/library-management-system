package com.esraa.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"book", "member", "borrowByUser"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "borrowing_transaction")
public class BorrowTransaction {

    @EqualsAndHashCode.Include
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
