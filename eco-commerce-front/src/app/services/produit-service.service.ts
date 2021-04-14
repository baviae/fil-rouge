import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { produit } from '../Models/produit';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  
  constructor(private http: HttpClient) { }


  getListeProduit (){
    return this.http.get(environment.baseurl+'/produits');
  }

  getProduit (id: number) : Observable<any>{
    return this.http.get(environment.baseurl+'/produit/' + id);
  }

  saveProduit(produit:produit){
    return this.http.post(environment.baseurl+'/produit', produit);
  }

  pushFileToStorage(id:number,file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();
    data.append('file', file);
    const newRequest = new HttpRequest('POST', environment.baseurl+'/image/'+id, data,  {
    reportProgress: true,
    responseType: 'text'
    });
    return this.http.request(newRequest);
  }

  getImagePrd(idProd:string, nomimg:string){
    return this.http.get(environment.baseurl+'/produits/image/'+idProd+'/'+nomimg, { responseType: 'blob' });
  }
}
