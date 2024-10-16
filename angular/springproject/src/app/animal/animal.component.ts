import { Component, OnInit } from '@angular/core';
import{Animal} from '../model/animal.model';
import{AnimalService}from'../service/animal.service';
import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit{
  ngOnInit(): void {
    this.animalService.listanimals().subscribe(anim => {
      console.log(anim);
      this.animals = anim;
      });
  }
  animals!: Animal[];
  constructor(private animalService : AnimalService,
    public authService: AuthService) { }
    
    chargerProduits(){
      this.animalService.listanimals().subscribe(ani => {
      console.log(ani);
      this.animals = ani;
      });
      }
      
    supprimeranimal(a:Animal){
      let conf = confirm("Etes-vous sûr ?");
      if (conf)
      this.animalService.supprimeranimal(a.id!).subscribe(() => {
      console.log("animal supprimé");
      this.chargerProduits();
      });
      /* let conf = confirm("Etes-vous sûr ?");
     if (conf)
      this.animalService.supprimeranimal(a); */
    
    }
}
