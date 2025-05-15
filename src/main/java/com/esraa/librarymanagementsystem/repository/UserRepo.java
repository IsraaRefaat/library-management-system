package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE role = CAST(:role AS user_role)", nativeQuery = true)
    List<User> findByRole(@Param("role") String role);

}
