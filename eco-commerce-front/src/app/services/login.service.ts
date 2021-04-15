import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { utilisateur } from '../Models/utilisateur';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  
  constructor(private http: HttpClient) { }

  gettoken(user:utilisateur):Observable<any> {
    return this.http.post(environment.baseurl +'/login',user);
  }

}
