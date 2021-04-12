import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { utilisateur } from '../Models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseurl = 'http://192.168.1.3:8080';
  constructor(private http: HttpClient) { }

  gettoken(user:utilisateur):Observable<any> {
    return this.http.post(this.baseurl +'/login',user);
  }

}
