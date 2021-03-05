import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConnecterService {

  logged = false;
  constructor() { }

  testLogged(){
    if (localStorage.getItem('token')) {
     return this.logged = true;
    } else {
     return this.logged = false;
    }
  }
}
