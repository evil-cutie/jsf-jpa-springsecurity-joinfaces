package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepositoryInterface extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
