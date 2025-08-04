package com.pawfectbuddy.service;

import com.pawfectbuddy.controller.dto.RegistrationRequest;
import com.pawfectbuddy.model.entity.Listing;
import com.pawfectbuddy.model.entity.Role;
import com.pawfectbuddy.model.entity.User;
import java.util.List;
import java.util.Set;

public interface UserServiceInterface {
    User registerUser(RegistrationRequest registrationRequest);
    User createUser(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    String encodePassword(String password);
    void deleteUser(User user);
    void updateUser(User user);
}
