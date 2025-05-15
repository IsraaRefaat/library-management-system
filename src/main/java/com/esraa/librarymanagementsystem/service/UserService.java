package com.esraa.librarymanagementsystem.service;


import com.esraa.librarymanagementsystem.entity.User;
import com.esraa.librarymanagementsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public User saveUser(User user) {
        return repo.save(user);
    }


}
