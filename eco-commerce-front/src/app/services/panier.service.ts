import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PanierService {

  private baseurl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getPanierUtilisateur (userId: string): Observable<any> {
	// Je suppose que /panier/{id_utilisateur} sera l'url de l'api
	// à appeler pour récupérer le panier associé à l'utilisateur
    return this.http.get(this.baseurl + '/panier/' + userId);
  }
}
