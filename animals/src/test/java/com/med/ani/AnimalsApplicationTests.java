package com.med.ani;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;
import com.med.ani.repos.AnimalRepository;

@SpringBootTest
class AnimalsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private AnimalRepository animalRepository;

	@Test
	public void testCreateAnimal() {
		Animal animal = new Animal("Tiger", 5, "Wild", null); // Animal without category
		animalRepository.save(animal);
	}	
	
	@Test
	public void testFindAnimal() {
		Animal animal = animalRepository.findById(1L).get();
		System.out.println(animal);
	}

	@Test
	public void testUpdateAnimal() {
		Animal animal = animalRepository.findById(1L).get();
		animal.setAge(6);
		animalRepository.save(animal);
	}
	
	@Test
	public void testDeleteAnimal() {
		animalRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousAnimals() {
		List<Animal> animals = animalRepository.findAll();
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	@Test
	public void testFindByNomAnimal() {
		List<Animal> animals = animalRepository.findByNom("Tiger");
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	@Test
	public void testFindByNomAnimalContains() {
		List<Animal> animals = animalRepository.findByNomContains("Ti");
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	
	@Test
	public void testfindByAnimalCategory() {
		AnimalCategory category = new AnimalCategory();
		category.setidCat(1L);
		List<Animal> animals = animalRepository.findByAnimalCategory(category);
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	@Test
	public void findByAnimalCategoryIdCat() {
		List<Animal> animals = animalRepository.findByAnimalCategoryIdCat(1L);
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	@Test
	public void testfindByOrderByNomAsc() {
		List<Animal> animals = animalRepository.findByOrderByNomAsc();
		for (Animal animal : animals) {
			System.out.println(animal);
		}
	}
	
	
}
