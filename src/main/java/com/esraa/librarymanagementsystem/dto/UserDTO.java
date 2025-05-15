package com.esraa.librarymanagementsystem.dto;

import com.esraa.librarymanagementsystem.entity.User;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String email;
    private User.UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.username = name;
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.role = u.getRole();
        this.createdAt = u.getCreatedAt();
        this.updatedAt = u.getUpdatedAt();
    }
}
