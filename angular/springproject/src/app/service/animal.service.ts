import { Injectable } from '@angular/core';
import{Animal} from '../model/animal.model'
import {animalCategory} from "../model/animalcategorie.model";
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CategorieWrapper } from '../model/animalcategoriewrapper.moel';
import { AuthService } from './auth.service';
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
  constructor(private http : HttpClient,private authService: AuthService) { 
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
  /* let jwt = this.authService.getToken();
  jwt = "Bearer "+jwt;
  let httpHeaders = new HttpHeaders({"Authorization":jwt})
  return this.http.get<Animal[]>(this.apiURL+"/all",{headers:httpHeaders});
   */
  return this.http.get<Animal[]>(this.apiURL+"/all");
}

listanimalcat():Observable<CategorieWrapper>{
        let jwt = this.authService.getToken();
        jwt = "Bearer "+jwt;
        let httpHeaders = new HttpHeaders({"Authorization":jwt})
        return  this.http.get<CategorieWrapper>(this.apiURLCat,{headers:httpHeaders});
        }


ajouteranimal(ani:Animal):Observable<Animal>{
  let jwt = this.authService.getToken();
jwt = "Bearer "+jwt;
let httpHeaders = new HttpHeaders({"Authorization":jwt})
return this.http.post<Animal>(this.apiURL+"/addani", ani, {headers:httpHeaders});
}


supprimeranimal(id:number){

const url = `${this.apiURL}/delani/${id}`;
        let jwt = this.authService.getToken();
        jwt = "Bearer "+jwt;
        let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
          return this.http.delete(url,  {headers:httpHeaders});
  /* const index=this.animals.indexOf(ani,0);
  if (index > -1) {
    this.animals.splice(index, 1);
    }
     */
}


consulteranimal(id:Number):Observable<Animal>{
  const url = `${this.apiURL}/getbyid/${id}`;
          console.log(url);
          let jwt = this.authService.getToken();
          jwt = "Bearer "+jwt;
          let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
            return this.http.get<Animal>(url,{headers:httpHeaders});
}
consultercat(id:number):animalCategory{
  return this.animalCategory.find(cat => cat.idCat == id)!;
}
updateanimal(a:Animal):Observable<Animal>{
  
          let jwt = this.authService.getToken();
          jwt = "Bearer "+jwt;
          let httpHeaders = new HttpHeaders({"Authorization":jwt}) 
            return this.http.put<Animal>(this.apiURL+"/updateani", a, {headers:httpHeaders});
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
