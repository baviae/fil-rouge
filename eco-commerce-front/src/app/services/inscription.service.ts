import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { utilisateur } from '../Models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  baseurl = 'http://192.168.1.3:8080';
  constructor(private http: HttpClient) { }

  inscrit(user:utilisateur){
    return this.http.post(this.baseurl +'/SignIn',user);
  }


}
