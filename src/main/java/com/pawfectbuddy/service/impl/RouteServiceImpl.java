package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.model.entity.Role;
import com.pawfectbuddy.model.entity.Route;
import com.pawfectbuddy.repository.RouteRepositoryInterface;
import com.pawfectbuddy.service.RouteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteServiceInterface {

    @Autowired
    private RouteRepositoryInterface routeRepository;

    @Override
    public List<Route> getRoutes() {
        return (List<Route>) routeRepository.findAll();
    }

    // map each route to certain role for accessing a url tied to this route
    @Override
    public Map<String, List<String>> getRouteRoleMapping(){
        Map<String, List<String>> map = new HashMap<>();
        List<Route> routes = getRoutes();
        for (Route route : routes) {
            if (!route.getRoles().isEmpty()) {
                List<String> roles = route.getRoles().stream()
                        .map(Role::getRoleName)
                        .collect(Collectors.toList());
                map.put(route.getRouteUrl(), roles);
            }
        }
        return map;
    }
}
