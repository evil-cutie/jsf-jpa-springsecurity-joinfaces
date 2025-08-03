package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.City;

import java.util.List;

public interface CityServiceInterface {

    List<String> getCityNames();
    City findByName(String name);
}
