import{animalCategory}from'../model/animalcategorie.model'
import{Image}from'../model/image.model'

export class Animal {
    id?: number;
    nom?: any;
    age?: number;
    type?: string;
    animalCategory!:animalCategory;
    images! : Image[];
    imageStr!:string
  categorie: any;

}