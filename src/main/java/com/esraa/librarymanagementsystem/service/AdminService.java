package com.esraa.librarymanagementsystem.service;

import com.esraa.librarymanagementsystem.dto.UserDTO;
import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.logging.ActivityLog;
import com.esraa.librarymanagementsystem.repository.ActivityLogRepo;
import com.esraa.librarymanagementsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceI{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



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
        List<User> users = userRepo.findByRole(User.UserRole.ADMIN);

        return getListResponseEntity(users);
    }


    public ResponseEntity<List<UserDTO>> getLibrarians() {
        List<User> users = userRepo.findByRole(User.UserRole.LIBRARIAN);

        return getListResponseEntity(users);
    }


    public ResponseEntity<List<UserDTO>> getStaff() {
        List<User> users = userRepo.findByRole(User.UserRole.STAFF);

        return getListResponseEntity(users);
    }

    public ResponseEntity<?> addUSer(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepo.save(user);

        ActivityLog log = new ActivityLog();
        log.setSystemUser(user);
        log.setAction("User added");
        log.setDescription("Admin add user."+ user.getRole().name());
        activityLogRepo.save(log);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity<?> updateUser(Integer id, UserDTO user) {
        Optional<User> existingUser = userRepo.findById(id);

        if (existingUser.isPresent()) {
            User usr = existingUser.get();
            user.setUsername(user.getUsername());
            user.setRole(user.getRole());

            userRepo.save(usr);

            ActivityLog log = new ActivityLog();
            log.setSystemUser(usr);
            log.setAction("User updated");
            log.setDescription("Admin update user."+ user.getRole().name());
            activityLogRepo.save(log);


            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    public ResponseEntity<?> deleteUser(Integer id) {
        Optional<User> usr = userRepo.findById(id);

        if (usr.isPresent()) {
            userRepo.deleteById(id);

            ActivityLog log = new ActivityLog();
            log.setSystemUser(usr.get());
            log.setAction("User deleted");
            log.setDescription("Admin deleted user."+ usr.get().getRole().name());
            activityLogRepo.save(log);


            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
