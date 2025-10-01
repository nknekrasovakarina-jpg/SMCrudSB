package com.example.smcrudsb.service;

import com.example.smcrudsb.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
