import { Component, OnInit } from '@angular/core';
import { panier } from '../Models/panier';
import { UsersConnecteServiceService } from '../services/users-connecte-service.service';
import { PanierService } from '../services/panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  panierUtilisateur: panier;
  
  constructor(
	private userService: UsersConnecteServiceService,
	private panierService: PanierService) { }

  ngOnInit(): void {
	//TODO appeler panierService avec l'id de l'utilisateur connecté
	this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any).subscribe(
		data => {
			console.log(data)
			this.panierUtilisateur = data;
			}
	);

  }

  supprimer(idPrd:number){
	this.panierService.supprimerProduit(idPrd,this.panierUtilisateur.id);
}
}
