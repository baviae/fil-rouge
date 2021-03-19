import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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

  pushFileToStorage(id:number,file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    const newRequest = new HttpRequest('POST', this.baseurl+'/image/'+id, data,  {
    reportProgress: true,
    responseType: 'text'
    });
    return this.http.request(newRequest);
  }

  getImagePrd(prd:produit){
    return this.http.post(this.baseurl+'/produits/image',prd,{responseType: 'text'});
  }
}
