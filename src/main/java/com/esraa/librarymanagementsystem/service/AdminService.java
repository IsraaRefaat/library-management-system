package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.UserDTO;
import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;


    private ResponseEntity<List<UserDTO>> getListResponseEntity(List<User> users) {
        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }

        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::new)
                .toList();

        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }


    public ResponseEntity<List<UserDTO>> getAdmins() {
        List<User> users = userRepo.findByRole("ADMIN");

        return getListResponseEntity(users);
    }


    public ResponseEntity<List<UserDTO>> getLibrarians() {
        List<User> users = userRepo.findByRole("LIBRARIAN");

        return getListResponseEntity(users);
    }


    public ResponseEntity<List<UserDTO>> getStaff() {
        List<User> users = userRepo.findByRole("STAFF");

        return getListResponseEntity(users);
    }

    public ResponseEntity<Optional<User>> addLibrarian(User user) {
        userRepo.save(user);
        return new ResponseEntity<>(userRepo.findById(user.getId()), HttpStatus.OK);
    }





}
