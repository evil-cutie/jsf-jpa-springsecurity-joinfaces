package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepositoryInterface extends CrudRepository<Role, Long> {
}
