package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.controller.dto.RegistrationRequest;
import com.pawfectbuddy.model.entity.Role;
import com.pawfectbuddy.model.entity.User;
import com.pawfectbuddy.repository.RoleRepositoryInterface;
import com.pawfectbuddy.repository.UserRepositoryInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserService has access to UserRepository for performing various CRUD methods upon a request from client
 * @author Xenia Levit
 */

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepositoryInterface userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepositoryInterface roleRepository;
    private final Long ROLE_USER = 2L;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    // register a new user with user role and active status by default
    // to set admin role need to manually map it in database
    @Override
    public User registerUser(RegistrationRequest registrationRequest) {
        if(findByUsername(registrationRequest.getUsername()) != null) {
            throw new EntityExistsException("Username already exists");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(ROLE_USER).get());
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setActive(true);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUsername(String username) { return userRepository.findByUsername(username).orElse(null); }

    public void updateUser(User user) {
        userRepository.save(user);
    }

}
