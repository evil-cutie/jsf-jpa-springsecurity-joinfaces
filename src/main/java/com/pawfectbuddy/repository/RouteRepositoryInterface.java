package com.pawfectbuddy.repository;

import com.pawfectbuddy.model.entity.Route;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits CrudRepository methods so we don't need to implement them.
 * This class is Autowired with RouteService to expose these methods to client
 * @author Xenia Levit
 */

public interface RouteRepositoryInterface extends CrudRepository<Route, Long> {
}
