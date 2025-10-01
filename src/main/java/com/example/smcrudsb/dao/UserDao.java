package com.example.smcrudsb.dao;

import com.example.smcrudsb.entity.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}