package com.esraa.librarymanagementsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

}
