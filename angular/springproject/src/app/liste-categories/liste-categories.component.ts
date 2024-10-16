import { Component, OnInit } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { animalCategory } from '../model/animalcategorie.model';
@Component({
  selector: 'app-liste-categories',
  templateUrl: './liste-categories.component.html',
  styleUrls: ['./liste-categories.component.css']
})
export class ListeCategoriesComponent implements OnInit {

  categories !:animalCategory[];
  ajout:boolean=true;

constructor(private animalsrevice : AnimalService){}
ngOnInit(): void {
    this.animalsrevice.listanimalcat().subscribe(cats=>{this.categories=cats._embedded.animalCategories;console.log(cats);})
}
updatedCat:animalCategory = {"idCat":0,"nomCat":"","descriptioncat":""};
chargerCategories(){
  this.animalsrevice.listanimalcat().
  subscribe(cats => {this.categories = cats._embedded.animalCategories;
  console.log(cats);
  });
  }
categorieUpdated(cat:animalCategory){
  console.log("Cat updated event",cat);
  this.animalsrevice.ajouterCategorie(cat).
   subscribe( ()=> this.chargerCategories());
  }
  updateCat(cat:animalCategory) {
this.updatedCat=cat;
this.ajout=false;
}



}
