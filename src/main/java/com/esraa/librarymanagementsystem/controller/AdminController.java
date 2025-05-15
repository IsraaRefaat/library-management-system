package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.dto.UserDTO;
import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping("admin")
    public ResponseEntity<List<UserDTO>> getAdmins() {
        return adminService.getAdmins();
    }

    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping("librarian")
    public ResponseEntity<List<UserDTO>> getLibrarians() {
        return adminService.getLibrarians();
    }

    @PreAuthorize("hasRole('ADMIM')")
    @PostMapping("librarian")
    public ResponseEntity<Optional<User>> addLibrarian(@RequestBody User user) {
        return adminService.addLibrarian(user);
    }


}
