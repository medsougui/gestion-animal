import { Component, OnInit } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { Animal } from '../model/animal.model';

@Component({
  selector: 'app-recherche-par-nom',
  templateUrl: './recherche-par-nom.component.html',
  styleUrls: ['./recherche-par-nom.component.css']
})
export class RechercheParNomComponent implements OnInit {

  nomAnimal! : string;
  animals!: Animal[];
  allAnimals!: Animal[];
  searchTerm!: string;
  
  constructor(private animalService : AnimalService) { }

  ngOnInit(): void {
    this.animalService.listanimals().subscribe(ani => {
      console.log(ani);
      this.animals = ani;
      });
      
  }

  rechercherProds(){
    this.animalService.rechercherParNom(this.nomAnimal).
    subscribe(ani => {
      console.log(ani);
      this.animals=ani;});
  }

  onKeyUp(filterText : string){
    this.animals = this.allAnimals.filter(item =>
    item.nom.toLowerCase().includes(filterText));
    }
    

}