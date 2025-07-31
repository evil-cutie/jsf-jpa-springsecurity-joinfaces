package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.model.entity.User;
import com.pawfectbuddy.repository.UserRepositoryInterface;
import com.pawfectbuddy.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepositoryInterface userRepository;

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
