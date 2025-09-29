package com.example.service;

import com.example.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
