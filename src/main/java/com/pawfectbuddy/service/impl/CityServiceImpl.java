package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.model.entity.City;
import com.pawfectbuddy.repository.CityRepositoryInterface;
import com.pawfectbuddy.service.CityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * CityService has access to CityRepository for performing various CRUD methods upon a request from client
 * @author Xenia Levit
 */

@Service
public class CityServiceImpl implements CityServiceInterface {

    @Autowired
    private CityRepositoryInterface cityRepository;

    @Override
    public List<String> getCityNames() {
        List<String> cityNames = new ArrayList<>();
        List<City> cities = (List<City>) cityRepository.findAll();
        for (City city : cities) {
            cityNames.add(city.getName());
        }
        return cityNames;
    }

    @Override
    public City findByName(String name) {
        List<City> cities = (List<City>) cityRepository.findAll();
        for (City city : cities) {
            if (city.getName().equals(name)) return city;
        }
        return null;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }
}
