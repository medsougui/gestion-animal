import { animalCategory } from './animalcategorie.model';
export class CategorieWrapper{
_embedded!: { animalCategories: animalCategory[]};
}