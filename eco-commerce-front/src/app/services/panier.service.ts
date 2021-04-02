import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { panier } from "../Models/panier";


@Injectable({
  providedIn: 'root'
})
export class PanierService {

  private baseurl = 'http://192.168.1.3:8080';
  constructor(private http: HttpClient) { }

  getPanierUtilisateur (userId: string): Observable<any> {
	// Je suppose que /panier/{id_utilisateur} sera l'url de l'api
	// � appeler pour r�cup�rer le panier associ� � l'utilisateur
    return this.http.get(this.baseurl + '/panier/' + userId);
  }

  supprimerProduit (prdId: number, panId: number): Observable<any> {
	return this.http.delete(this.baseurl + '/panier/' + panId + '/' + prdId);
  }

  viderPanier (panId: number): Observable<any> {
	return this.http.delete(this.baseurl + '/viderpanier/' + panId);
  }

  ajoutdansPanier (userId: number, pan: panier): Observable<any> {
	return this.http.post(this.baseurl + '/panier/' + userId, pan);
  }


}
