import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { utilisateur } from 'app/Models/utilisateur';


@Injectable()
export class LoginService {

  baseurl = 'http://localhost:8080';
  constructor(private http: Http) { }


  gettoken(user:utilisateur){
    return this.http.post('/login',user);
  }

}
