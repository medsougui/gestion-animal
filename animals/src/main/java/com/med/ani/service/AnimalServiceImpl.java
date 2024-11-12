package com.med.ani.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;
import com.med.ani.repos.ImageRepository;
import com.med.ani.repos.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        // Uncomment if you want to handle old image deletion when updating the animal
        // Long oldAnimalImageId = this.getAnimal(animal.getId()).getImages().get(0).getIdImage();
        // Long newAnimalImageId = animal.getImages().get(0).getIdImage();
        Animal updatedAnimal = animalRepository.save(animal);
        // if (!oldAnimalImageId.equals(newAnimalImageId)) {
        //     imageRepository.deleteById(oldAnimalImageId);
        // }
        return updatedAnimal;
    }

    @Override
    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
        // Delete image files before deleting the animal
        Animal animal = getAnimal(id);
        try {
            Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + animal.getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        animalRepository.deleteById(id);
    }

    @Override
    public Animal getAnimal(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found with ID: " + id));
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> findByNom(String nom) {
        return animalRepository.findByNom(nom);
    }

    @Override
    public List<Animal> findByNomContains(String nom) {
        return animalRepository.findByNomContains(nom);
    }

    @Override
    public List<Animal> findByNomAndAgeGreaterThan(String nom, Integer age) {
        return animalRepository.findByNomAndAgeGreaterThan(nom, age);
    }

    @Override
    public List<Animal> findByAnimalCategory(AnimalCategory animalCategory) {
        return animalRepository.findByAnimalCategory(animalCategory);
    }

    @Override
    public List<Animal> findByAnimalCategoryIdCat(Long id) {
        return animalRepository.findByAnimalCategoryIdCat(id);
    }

    @Override
    public List<Animal> findByOrderByNomAsc() {
        return animalRepository.findByOrderByNomAsc();
    }

    @Override
    public List<Animal> sortAnimalsByNameAndAge() {
        return animalRepository.sortAnimalsByNameAndAge();
    }
}
