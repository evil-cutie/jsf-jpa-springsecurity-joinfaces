package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.City;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with CityService to expose these methods to client
 * @author Xenia Levit
 */

public interface CityRepositoryInterface extends CrudRepository<City, Long> {
}
