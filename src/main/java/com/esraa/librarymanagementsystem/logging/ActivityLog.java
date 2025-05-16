package com.esraa.librarymanagementsystem.logging;

import com.esraa.librarymanagementsystem.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "activity_log")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "system_user_id")
    private User systemUser;

    private String action;

    private LocalDateTime timestamp = LocalDateTime.now();

    private String description;
}

