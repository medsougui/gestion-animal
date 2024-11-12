package com.med.ani.service;

import java.util.List;

import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;

public interface AnimalService {

    // Save a new animal
    Animal saveAnimal(Animal animal);

    // Update an existing animal
    Animal updateAnimal(Animal animal);

    // Delete an animal
    void deleteAnimal(Animal animal);

    // Delete an animal by its ID
    void deleteAnimalById(Long id);

    // Get an animal by its ID
    Animal getAnimal(Long id);

    // Get all animals
    List<Animal> getAllAnimals();

    // Find animals by name
    List<Animal> findByNom(String nom);

    // Find animals by name containing a specific substring
    List<Animal> findByNomContains(String nom);

    // Find animals by name and age greater than a specific value
    List<Animal> findByNomAndAgeGreaterThan(String nom, Integer age);

    // Find animals by category
    List<Animal> findByAnimalCategory(AnimalCategory animalCategory);

    // Find animals by category ID
    List<Animal> findByAnimalCategoryIdCat(Long id);

    // Get a list of animals ordered by name in ascending order
    List<Animal> findByOrderByNomAsc();

    // Sort animals by name in ascending order and age in descending order
    List<Animal> sortAnimalsByNameAndAge();
}
