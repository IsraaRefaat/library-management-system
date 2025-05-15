package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    List<User> findByRole(User.UserRole role);

}
