import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ListeUserService {
  
  constructor(private http: HttpClient) { }


  getListe (){
    return this.http.get(environment.baseurl+'/utilisateurs');
  }
}
