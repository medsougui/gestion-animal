import{animalCategory}from'../model/animalcategorie.model'
export class Animal {
    id?: number;
    nom?: any;
    age?: number;
    type?: string;
    animalCategory!:animalCategory;
}