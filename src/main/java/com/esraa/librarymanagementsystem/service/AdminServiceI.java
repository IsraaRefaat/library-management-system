package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.UserDTO;
import com.esraa.librarymanagementsystem.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface AdminServiceI {

     ResponseEntity<List<UserDTO>> getAdmins();

     ResponseEntity<List<UserDTO>> getLibrarians();

     ResponseEntity<List<UserDTO>> getStaff();

     ResponseEntity<?> addUSer(User user);

     ResponseEntity<?> updateUser(Integer id, UserDTO user);

     ResponseEntity<?> deleteUser(Integer id);

}
