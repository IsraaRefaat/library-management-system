package com.esraa.librarymanagementsystem.dto;

import com.esraa.librarymanagementsystem.entity.User;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String username;
    private String email;
    private User.UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDTO(String name) {
        this.username = name;
    }

    public UserDTO(User u) {
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.role = u.getRole();
        this.createdAt = u.getCreatedAt();
        this.updatedAt = u.getUpdatedAt();
    }
}
