import { Component, OnInit } from '@angular/core';
import{Animal}from '../model/animal.model'
import{AnimalService}from'../service/animal.service';
import {animalCategory} from "../model/animalcategorie.model";
import { Router } from "@angular/router";
import{Image} from '../model/image.model'
@Component({
  selector: 'app-add-animal',
  templateUrl: './add-animal.component.html',
  styleUrls: ['./add-animal.component.css']
})
export class AddAnimalComponent implements OnInit {
  animalCategory! : animalCategory[];
newIdCat! : number;
newCategorie! : animalCategory;


newanimal= new Animal();
constructor(private animalService:AnimalService,private router :Router){}
  

ngOnInit(): void {
  this.animalService.listanimalcat().
subscribe(cats => {console.log(cats);
  this.animalCategory = cats._embedded.animalCategories; });

  }


addanimal(){
this.animalService
.uploadImage(this.uploadedImage, this.uploadedImage.name)
.subscribe((img: Image) => {
this.newanimal.image=img;
this.newanimal.categorie = this.animalCategory.find(cat => cat.idCat
== this.newIdCat)!;
this.animalService
.ajouteranimal(this.newanimal)
.subscribe(() => {
this.router.navigate(['animals']);
});
});

 /* this.newanimal.animalCategory = this.animalCategory.find(cat => cat.idCat == this.newIdCat)!;
this.animalService.ajouteranimal(this.newanimal)
.subscribe(ani => {
console.log(ani);
this.router.navigate(['animal']);
});

  this.animalService.ajouteranimal(this.newanimal)
.subscribe(ani => {
console.log(ani);
this.router.navigate(['animal']);
});
   this.newCategorie=this.animalService.consultercat(this.newIdCat);
  this.newanimal.animalCategory=this.newCategorie;
  this.animalService.ajouteranimal(this.newanimal);
  this.router.navigate(['animal']); */

}

uploadedImage!: File;
imagePath: any;

onImageUpload(event: any) {
  this.uploadedImage = event.target.files[0];
  var reader = new FileReader();
  reader.readAsDataURL(this.uploadedImage);
  reader.onload = (_event) => { this.imagePath = reader.result; }
  }
  
}
