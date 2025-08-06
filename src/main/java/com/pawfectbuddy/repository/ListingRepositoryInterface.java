package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Listing;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with ListingService to expose these methods to client
 * @author Xenia Levit
 */

public interface ListingRepositoryInterface extends CrudRepository<Listing, Long> {
}
