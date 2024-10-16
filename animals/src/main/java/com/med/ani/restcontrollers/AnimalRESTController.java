package com.med.ani.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.med.ani.dto.AnimalDTO;
import com.med.ani.entities.Animal;
import com.med.ani.service.AnimalService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimalRESTController {
    
    @Autowired
    private AnimalService animalService;
    
    // GET all animals
    @RequestMapping(method = RequestMethod.GET)
    public List<AnimalDTO > getAllAnimals() {
        return animalService.getAllAnimals();
    }
    
    // GET animal by ID
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public AnimalDTO  getAnimalById(@PathVariable("id") Long id) {
        return animalService.getAnimal(id);
    }
    
    // POST create a new animal
    @RequestMapping(method = RequestMethod.POST)
    public AnimalDTO  createAnimal(@RequestBody AnimalDTO animal) {
        return animalService.saveAnimal(animal);
    }
    
    // PUT update an existing animal
    @RequestMapping(method = RequestMethod.PUT)
    public Animal updateAnimal(@RequestBody AnimalDTO animal) {
        return animalService.updateAnimal(animal);
    }
    
    // DELETE an animal by ID
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
    }
    
    // GET animals by category ID
    @RequestMapping(value="/animalscat/{id_Cat}", method = RequestMethod.GET)
    public List<Animal> getAnimalsByCategoryId(@PathVariable("id_Cat") Long id_Cat) {
        return animalService.findByAnimalCategoryIdCat(id_Cat);
    }
    
    @RequestMapping(value="/aniByName/{nom}",method = RequestMethod.GET)
    public List<Animal> findByNomProduitContains(@PathVariable("nom") String nom) {
    return animalService.findByNomContains(nom);
    }
}
