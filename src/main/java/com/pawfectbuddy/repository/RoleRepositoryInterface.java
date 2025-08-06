package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with RoleService to expose these methods to client
 * @author Xenia Levit
 */

public interface RoleRepositoryInterface extends CrudRepository<Role, Long> {
}
