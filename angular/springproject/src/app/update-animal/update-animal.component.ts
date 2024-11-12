import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {Animal} from "../model/animal.model";
import { AnimalService } from '../service/animal.service';
import {animalCategory} from "../model/animalcategorie.model";
import{Image} from '../model/image.model'
@Component({
  selector: 'app-update-animal',
  templateUrl: './update-animal.component.html',
  styleUrls: ['./update-animal.component.css']
})
export class UpdateAnimalComponent implements OnInit {
  currentanimal=new Animal();
  animalcategories! : animalCategory[];
  updatedCatId! : number;
  myImage! : string;
  uploadedImage!: File;
  isImageUpdated: Boolean=false;
  
  constructor (private animalService:AnimalService,private activatedRoute:ActivatedRoute,private router:Router){}
  ngOnInit(): void {
    this.animalService.listanimalcat().
subscribe(cats => {console.log(cats);
          this.animalcategories=cats._embedded.animalCategories;
});

this.animalService.consulteranimal(this.activatedRoute.snapshot.params['id']).
subscribe( prod =>{ this.currentanimal = prod;
this.updatedCatId =
this.currentanimal.animalCategory.idCat;
this.animalService
.loadImage(this.currentanimal.image.idImage)
.subscribe((img: Image) => {
this.myImage = 'data:' + img.type + ';base64,' + img.image;
}); 
});}
    /*this.animalService.consulteranimal(this.activatedRoute.snapshot.params['id']).
 subscribe( ani =>{ this.currentanimal = ani; } ) ;
     this.animalcategories=this.animalService.listanimalcat();
    this.currentanimal=this.animalService.consulteranimal(this.activatedRoute.snapshot.params['id']);
    this.updatedCatId=this.currentanimal.animalCategory.idcat; */
  
updateanimal(){
  /*this.currentanimal.animalCategory = this.animalcategories.
  find(cat => cat.idCat == this.updatedCatId)!;
 this.animalService.updateanimal(this.currentanimal).subscribe(ani => {
 this.router.navigate(['animal']); }
 );
  this.animalService.updateanimal(this.currentanimal).subscribe(ani => {
    this.router.navigate(['animal']); }
    );
    
   this.currentanimal.animalCategory=this.animalService.consultercat(this.updatedCatId);
  this.animalService.updateanimal(this.currentanimal);
  this.router.navigate(['animal']); */

  this.currentanimal.categorie = this.animalcategories.find(cat => cat.idCat ==
    this.updatedCatId)!;
    //tester si l'image du produit a été modifiée
    if (this.isImageUpdated)
    {
    this.animalService
    .uploadImage(this.uploadedImage, this.uploadedImage.name)
    .subscribe((img: Image) => {
    this.currentanimal.image = img;
    this.animalService
    .updateanimal(this.currentanimal)
    .subscribe((ani) => {
    this.router.navigate(['animal']);
    });
    });
    }
    else{
    this.animalService
    .updateanimal(this.currentanimal)
    .subscribe((ani) => {
    this.router.navigate(['animal']);
    });
    }


};
onImageUpload(event: any) {
  if(event.target.files && event.target.files.length) {
  this.uploadedImage = event.target.files[0];
  this.isImageUpdated =true;
  const reader = new FileReader();
  reader.readAsDataURL(this.uploadedImage);
  reader.onload = () => { this.myImage = reader.result as string; };
  }
  }
  
}
