import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { utilisateur } from '../Models/utilisateur';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  constructor(private http: HttpClient) { }

  inscrit(user:utilisateur){
    return this.http.post(environment.baseurl +'/SignIn',user);
  }


}
