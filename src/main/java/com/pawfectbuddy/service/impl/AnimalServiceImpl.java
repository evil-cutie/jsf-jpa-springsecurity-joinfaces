package com.pawfectbuddy.service.impl;

import com.pawfectbuddy.model.entity.Animal;
import com.pawfectbuddy.repository.AnimalRepositoryInterface;
import com.pawfectbuddy.service.AnimalServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * AnimalService has access to AnimalRepository for performing various CRUD methods upon a request from client
 * @author Xenia Levit
 */

@Service
public class AnimalServiceImpl implements AnimalServiceInterface {

    @Autowired
    private AnimalRepositoryInterface animalRepository;

    @Override
    public List<String> getAnimalNames() {
        List<Animal> all = (List<Animal>) animalRepository.findAll();
        List<String> animals = new ArrayList<>();
        for (Animal animal : all) {
            animals.add(animal.getType());
        }
        return animals;
    }

    @Override
    public Animal findByName(String name) {
        List<Animal> all = (List<Animal>) animalRepository.findAll();
        for (Animal animal : all) {
            if (animal.getType().equals(name)) return animal;
        }
        return null;
    }

    @Override
    public Animal findById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }
}
