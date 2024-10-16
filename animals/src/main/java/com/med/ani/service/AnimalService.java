package com.med.ani.service;

import java.util.List;

import com.med.ani.dto.AnimalDTO;
import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;

public interface AnimalService {
    AnimalDTO saveAnimal(AnimalDTO animal);
    AnimalDTO getAnimal(Long id);
    List<AnimalDTO> getAllAnimals();
    
    
    Animal updateAnimal(AnimalDTO animal);
    
    void deleteAnimal(Animal animal);
    void deleteAnimalById(Long id);   
    List<Animal> findByNom(String nom);
    List<Animal> findByNomContains(String nom);
    List<Animal> findByNomAndAge(String nom, Integer age);
    List<Animal> findByAnimalCategory(AnimalCategory animalCategory);
    List<Animal> findByAnimalCategoryIdCat(Long id_Cat);
    List<Animal> findByOrderByNomAsc();
    List<Animal> sortAnimalsByNameAndAge();
    AnimalDTO convertEntityToDto (Animal animal);
    Animal convertDtoToEntity(AnimalDTO animalDTO);

}
