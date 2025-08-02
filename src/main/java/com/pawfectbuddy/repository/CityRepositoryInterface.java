package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepositoryInterface extends CrudRepository<City, Long> {
}
