package com.esraa.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate joinDate;
    @OneToMany(mappedBy = "member")
    private List<BorrowTransaction> borrowTransactions;
}
