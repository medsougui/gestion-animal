package com.med.ani.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Find animals by name
    List<Animal> findByNom(String nom);

    // Find animals where the name contains a specific string
    List<Animal> findByNomContains(String nom);

    // Find animals by name pattern and age greater than a certain value
    @Query("select a from Animal a where a.nom like %:nom and a.age > :age")
    List<Animal> findByNomAndAgeGreaterThan(@Param("nom") String nom, @Param("age") Integer age);

    // Find animals by category
    @Query("select a from Animal a where a.animalCategory = ?1")
    List<Animal> findByAnimalCategory(AnimalCategory animalCategory);

    // Find animals by category ID
    List<Animal> findByAnimalCategoryIdCat(Long id);

    // Get all animals sorted by name in ascending order
    List<Animal> findByOrderByNomAsc();

    // Sort animals by name in ascending order and by age in descending order
    @Query("select a from Animal a order by a.nom ASC, a.age DESC")
    List<Animal> sortAnimalsByNameAndAge();
}
