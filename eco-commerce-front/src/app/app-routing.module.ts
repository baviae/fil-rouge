import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
{path: ' ', component: AppComponent},
{path: 'login', component: LoginComponent},
{path: 'inscription', component: InscriptionComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
