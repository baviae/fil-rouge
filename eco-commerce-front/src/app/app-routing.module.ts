import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AjoutProduitComponent } from './ajout-produit/ajout-produit.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { PanierComponent } from './panier/panier.component';

const routes: Routes = [
{path: '', component: AcceuilComponent},
{path: 'ajoutProduit', component: AjoutProduitComponent},
{path: 'login', component: LoginComponent},
{path: 'panier', component: PanierComponent},
{path: 'inscription', component: InscriptionComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
