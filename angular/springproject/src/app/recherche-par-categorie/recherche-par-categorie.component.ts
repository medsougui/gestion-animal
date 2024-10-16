import { Component, OnInit } from '@angular/core';
import { Animal } from '../model/animal.model';
import{AnimalService}from'../service/animal.service';
import { animalCategory } from '../model/animalcategorie.model';
@Component({
  selector: 'app-recherche-par-categorie',
  templateUrl: './recherche-par-categorie.component.html',
  styleUrls: ['./recherche-par-categorie.component.css']
})
export class RechercheParCategorieComponent implements OnInit {
  IdCategorie! : number;
  categories! : animalCategory[];
  animals! : Animal[];


  constructor(private animalService : AnimalService) { }

  ngOnInit(): void {
    this.animalService.listanimalcat().
      subscribe(cats => {this.categories = cats._embedded.animalCategories;
      console.log(cats);
    });

  }

  onChange() {
    this.animalService.rechercherParCategorie(this.IdCategorie).
      subscribe(ani =>{this.animals=ani});

    }

}