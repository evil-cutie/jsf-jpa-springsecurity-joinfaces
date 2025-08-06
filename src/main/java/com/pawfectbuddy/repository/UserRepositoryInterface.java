package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with UserService to expose these methods to client
 * @author Xenia Levit
 */

public interface UserRepositoryInterface extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
