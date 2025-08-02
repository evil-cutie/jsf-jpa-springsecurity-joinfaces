package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepositoryInterface extends CrudRepository<Animal, Long> {
}
