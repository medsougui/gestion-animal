package com.med.ani.service;
import com.med.ani.dto.AnimalDTO;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.med.ani.dto.AnimalDTO;
import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;
import com.med.ani.repos.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public AnimalDTO saveAnimal(AnimalDTO animal) {
        return convertEntityToDto(animalRepository.save(convertDtoToEntity(animal)));
    }

    @Override
    public Animal updateAnimal(AnimalDTO animal) {
        return animalRepository.save(convertDtoToEntity(animal));
    }

    @Override
    public void deleteAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public AnimalDTO  getAnimal(Long id) {
        return convertEntityToDto(animalRepository.findById(id).orElse(null));
    }

    @Override
    public List<AnimalDTO > getAllAnimals() {
        return  animalRepository.findAll().stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());
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
    public List<Animal> findByNomAndAge(String nom, Integer age) {
        return animalRepository.findByNomAndAge(nom, age);
    }

    @Override
    public List<Animal> findByAnimalCategory(AnimalCategory animalCategory) {
        return animalRepository.findByAnimalCategory(animalCategory);
    }

    @Override
    public List<Animal> findByAnimalCategoryIdCat(Long idCat) {
        return animalRepository.findByAnimalCategoryIdCat(idCat);
    }

    @Override
    public List<Animal> findByOrderByNomAsc() {
        return animalRepository.findByOrderByNomAsc();
    }

    @Override
    public List<Animal> sortAnimalsByNameAndAge() {
        return animalRepository.sortAnimalsByNameAndAge();
    }
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public AnimalDTO convertEntityToDto(Animal animal) {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
     AnimalDTO animalDTO = modelMapper.map(animal, AnimalDTO.class);
    		 return animalDTO; 
    }
     @Override
     public Animal convertDtoToEntity(AnimalDTO animalDto) {
    	 
    	 Animal animal = new Animal();
    	 animal=modelMapper.map(animalDto,Animal.class);
      return animal;
     }
    
    
}
