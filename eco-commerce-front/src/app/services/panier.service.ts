import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


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
}
