package com.pawfectbuddy.service;

import com.pawfectbuddy.model.entity.Animal;

import java.util.List;

public interface AnimalServiceInterface {

    List<String> getAnimalNames();
    Animal findByName(String name);
}
