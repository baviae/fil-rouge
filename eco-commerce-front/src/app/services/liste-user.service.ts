import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListeUserService {
  baseurl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }


  getListe (){
    return this.http.get(this.baseurl+'/utilisateurs');
  }
}
