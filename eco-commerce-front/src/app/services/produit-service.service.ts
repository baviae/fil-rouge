import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  baseurl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }


  getListeProduit (){
    return this.http.get(this.baseurl+'/produits');
  }
}
