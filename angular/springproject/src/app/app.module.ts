import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{FormsModule} from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BindingComponent } from './binding/binding.component';
import { AnimalComponent } from './animal/animal.component';
import { AddAnimalComponent } from './add-animal/add-animal.component';
import { UpdateAnimalComponent } from './update-animal/update-animal.component';
import { HttpClientModule } from '@angular/common/http';
import { RechercheParCategorieComponent } from './recherche-par-categorie/recherche-par-categorie.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeCategoriesComponent } from './liste-categories/liste-categories.component';
import { UpdateCategorieComponent } from './update-categorie/update-categorie.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
@NgModule({
  declarations: [
    AppComponent,
    BindingComponent,
    AnimalComponent,
    AddAnimalComponent,
    UpdateAnimalComponent,
    RechercheParCategorieComponent,
    SearchFilterPipe,
    RechercheParNomComponent,
    ListeCategoriesComponent,
    UpdateCategorieComponent,
    LoginComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }