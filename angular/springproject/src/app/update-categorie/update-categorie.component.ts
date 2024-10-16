import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { animalCategory } from '../model/animalcategorie.model';

@Component({
  selector: 'app-update-categorie',
  templateUrl: './update-categorie.component.html',
  styleUrls: ['./update-categorie.component.css']
})

export class UpdateCategorieComponent implements OnInit{
@Input()
categorie!:animalCategory;
@Output()
categorieUpdated = new EventEmitter<animalCategory>();
@Input()
ajout!:boolean;
ngOnInit(): void {
  console.log("ngOnInit du composant UpdateCategorie ",this.categorie);

}
saveCategorie(){
  this.categorieUpdated.emit(this.categorie);
  }
  
}
