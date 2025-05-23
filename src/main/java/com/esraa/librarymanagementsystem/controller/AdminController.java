package com.esraa.librarymanagementsystem.controller;

import com.esraa.librarymanagementsystem.dto.UserDTO;
import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.service.AdminServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminServiceI adminService;


    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAdmins() {
        return adminService.getAdmins();
    }

    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping("librarian")
    public ResponseEntity<List<UserDTO>> getLibrarians() {
        return adminService.getLibrarians();
    }

    @PreAuthorize("hasRole('ADMIM')")
    @GetMapping("staff")
    public ResponseEntity<List<UserDTO>> getStaff() {
        return adminService.getStaff();
    }

    @PreAuthorize("hasRole('ADMIM')")
    @PostMapping("librarian")
    public ResponseEntity<?> addLibrarian(@RequestBody User user) {
        return adminService.addUSer(user);
    }

    @PreAuthorize("hasRole('ADMIM')")
    @PostMapping("staff")
    public ResponseEntity<?> addStaff(@RequestBody User user) {
        return adminService.addUSer(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO user) {
        return adminService.updateUser(id,user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return adminService.deleteUser(id);
    }

}
