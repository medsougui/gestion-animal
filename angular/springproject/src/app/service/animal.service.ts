import { Injectable } from '@angular/core';
import{Animal} from '../model/animal.model'
import {animalCategory} from "../model/animalcategorie.model";
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CategorieWrapper } from '../model/animalcategoriewrapper.moel';
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};
@Injectable({
  providedIn: 'root'
})
export class AnimalService {
  apiURL: string = 'http://localhost:8083/animals/api';
  apiURLCat: string ='http://localhost:8083/animals/cat';
  
  animalCategory!:animalCategory[];
  animal!:Animal;
  animals !: Animal[]; 
  constructor(private http : HttpClient) { 
    /* this.animalcat=[
      {
        idcat: 1,
        description_cat: "Carnivorous animal",
        nomCat: "Carnivorous"
      },
      {
        idcat: 2,
        description_cat: "Herbivores Animals",
        nomCat: "Herbivores"
      }
    ];
    this.animals=[
      {
        idAnimal: 1,
        nomAnimal: "Lion",
        ageAnimal: 5,
        typeAnimal: "Wild",
        animalcategorie: this.animalcat[0]
      },
      {
        idAnimal: 2,
        nomAnimal: "Elephant",
        ageAnimal: 10,
        typeAnimal: "Wild",
        animalcategorie: this.animalcat[1]
      },
      {
        idAnimal: 3,
        nomAnimal: "Dog",
        ageAnimal: 3,
        typeAnimal: "Domestic",
        animalcategorie: this.animalcat[0]
      }
    ];*/
  } 
listanimals():Observable<Animal[]>{
return this.http.get<Animal[]>(this.apiURL);
}
listanimalcat():Observable<CategorieWrapper>{
  return this.http.get<CategorieWrapper>(this.apiURLCat);
}
ajouteranimal(ani:Animal):Observable<Animal>{
  return this.http.post<Animal>(this.apiURL, ani, httpOptions);
}
supprimeranimal(id:number){
  const url = `${this.apiURL}/${id}`;
return this.http.delete(url, httpOptions);

  /* const index=this.animals.indexOf(ani,0);
  if (index > -1) {
    this.animals.splice(index, 1);
    }
     */
}
consulteranimal(id:Number):Observable<Animal>{
  const url = `${this.apiURL}/${id}`;
  return this.http.get<Animal>(url);
}
consultercat(id:number):animalCategory{
  return this.animalCategory.find(cat => cat.idCat == id)!;
}
updateanimal(a:Animal):Observable<Animal>{
  return this.http.put<Animal>(this.apiURL, a, httpOptions);
  /* this.supprimeranimal(a.id!);
  this.ajouteranimal(a); */
}

trieranimals(){
  this.animals = this.animals.sort((n1,n2) => {
  if (n1.id! > n2.id!) {
  return 1;
  }
  if (n1.id! < n2.id!) {
  return -1;
  }
  return 0;
  });
  }
  rechercherParCategorie(idCat: number):Observable< Animal[]> {
    const url = `${this.apiURL}/animalscat/${idCat}`;
    return this.http.get<Animal[]>(url);
    }


    rechercherParNom(nom: String):Observable< Animal[]> {
      const url = `${this.apiURL}/aniByName/${nom}`;
      return this.http.get<Animal[]>(url);
      }
      ajouterCategorie( cat: animalCategory):Observable<animalCategory>{
        return this.http.post<animalCategory>(this.apiURLCat, cat, httpOptions);
        }


}
