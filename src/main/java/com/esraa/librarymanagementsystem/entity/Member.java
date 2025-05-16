package com.esraa.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate joinDate;

    @PrePersist
    public void onJoin() {
        this.joinDate = LocalDate.now();
    }

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<BorrowTransaction> borrowTransactions;
}
