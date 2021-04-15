import { Component, OnInit } from '@angular/core';
import { panier } from '../Models/panier';
import { PanierService } from '../services/panier.service';
import { Observable, BehaviorSubject, Subscription } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { produit } from '../Models/produit';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  appelApi$ = new BehaviorSubject(undefined);
  subscriptions: Subscription[] = [];
  
  panierUtilisateur$:  Observable<panier>  = this.appelApi$.pipe(
	        switchMap(() => this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any)));
  showPanier$: Observable<boolean> = this.panierUtilisateur$.pipe(map(data => data != null && data.produits.length > 0));
  produits$: Observable<produit[]> = this.panierUtilisateur$.pipe(map(pan => pan.produits));
  panierUtilisateur: panier;
  
  constructor(private panierService: PanierService) { }

  ngOnInit(): void {
	//TODO appeler panierService avec l'id de l'utilisateur connecté
	/*this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any).subscribe(
		data => {
			console.log(data)
			this.panierUtilisateur = data;
			 if (this.panierUtilisateur != null && this.panierUtilisateur.produits.length > 0) {
				this.showPanier = true;
			 }
			}
	);*/
	this.subscriptions.push(this.panierUtilisateur$.subscribe(
		data => {
			console.log(data)
			this.panierUtilisateur = data;
			}));

  }

  supprimer(idPrd:number){
	this.subscriptions.push(this.panierService.supprimerProduit(idPrd,this.panierUtilisateur.id)
		.subscribe(unused => {
			console.log("Le produit a été supprimé du panier");
			this.appelApi$.next(undefined);
		}));
   }

   vider() {
	  if(confirm("Voulez-vous vraiment vider le panier ?")) {
		
		this.subscriptions.push(this.panierService.viderPanier(this.panierUtilisateur.id)
		.subscribe(unused => {
				console.log("Le panier a été vidé");
				this.appelApi$.next(undefined);
			}));
		}
   }

	ngOndestroy() {
		this.subscriptions.forEach( sub => sub.unsubscribe());
	}
}
