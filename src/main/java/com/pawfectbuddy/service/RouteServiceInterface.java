package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.Route;

import java.util.List;
import java.util.Map;

public interface RouteServiceInterface {
    List<Route> getRoutes();
    Map<String, List<String>> getRouteRoleMapping();
}
