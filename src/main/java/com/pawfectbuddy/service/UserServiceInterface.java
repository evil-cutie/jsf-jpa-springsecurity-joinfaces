package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.User;
import java.util.List;

public interface UserServiceInterface {
    User createUser(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteUser(User user);
    void updateUser(User user);
}
