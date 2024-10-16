package com.med.ani.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByNom(String nom);
    List<Animal> findByNomContains(String nom);
    List<Animal> findByNomAndAge(String nom, Integer age);
    List<Animal> findByAnimalCategory(AnimalCategory animalCategory);
    List<Animal> findByAnimalCategoryIdCat(Long idCat);
    List<Animal> findByOrderByNomAsc();
    @Query("SELECT a FROM Animal a ORDER BY a.nom ASC, a.age ASC")
    List<Animal> sortAnimalsByNameAndAge();    
}
