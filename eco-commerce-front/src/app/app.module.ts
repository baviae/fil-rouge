import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { InscriptionComponent } from './inscription/inscription.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TokenhandlerforhttpreqService } from './services/tokenhandlerforhttpreq.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    InscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: TokenhandlerforhttpreqService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
