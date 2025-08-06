package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with AnimalService to expose these methods to client
 * @author Xenia Levit
 */

public interface AnimalRepositoryInterface extends CrudRepository<Animal, Long> {
}
