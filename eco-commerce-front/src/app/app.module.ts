import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TokenhandlerforhttpreqService } from './services/tokenhandlerforhttpreq.service';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AjoutProduitComponent } from './ajout-produit/ajout-produit.component';
import { NgxFileHelpersModule } from 'ngx-file-helpers';
import { PanierComponent } from './panier/panier.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    InscriptionComponent,
    AcceuilComponent,
    AjoutProduitComponent,
    PanierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxFileHelpersModule,
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: TokenhandlerforhttpreqService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
