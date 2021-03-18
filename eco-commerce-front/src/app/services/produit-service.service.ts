import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { produit } from '../Models/produit';

@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  baseurl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }


  getListeProduit (){
    return this.http.get(this.baseurl+'/produits');
  }

  saveProduit(produit:produit){
    return this.http.post(this.baseurl+'/produit', produit);
  }
}
