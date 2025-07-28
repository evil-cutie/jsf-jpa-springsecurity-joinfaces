package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepositoryInterface extends CrudRepository<Listing, Long> {
}
