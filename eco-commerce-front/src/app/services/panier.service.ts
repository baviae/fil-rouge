import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { panier } from "../Models/panier";
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  
  constructor(private http: HttpClient) { }

  getPanierUtilisateur (userId: string): Observable<any> {
	// Je suppose que /panier/{id_utilisateur} sera l'url de l'api
	// � appeler pour r�cup�rer le panier associ� � l'utilisateur
    return this.http.get(environment.baseurl + '/panier/' + userId);
  }

  supprimerProduit (prdId: number, panId: number): Observable<any> {
	return this.http.delete(environment.baseurl + '/panier/' + panId + '/' + prdId);
  }

  viderPanier (panId: number): Observable<any> {
	return this.http.delete(environment.baseurl + '/viderpanier/' + panId);
  }

  ajoutdansPanier (userId: number, idPrd: number): Observable<any> {
	console.log('hello2')
	return this.http.post(environment.baseurl + '/panier/' + userId + '/'+ idPrd, {});
	
  }


}
