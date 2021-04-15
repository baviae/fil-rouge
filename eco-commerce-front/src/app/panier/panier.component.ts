import { Component, OnDestroy, OnInit } from '@angular/core';
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
export class PanierComponent implements OnInit, OnDestroy {

  appelApi$ = new BehaviorSubject(undefined);
  subscriptions: Subscription[] = [];
  
  panierUtilisateur$:  Observable<panier>;
  showPanier$: Observable<boolean>; 
  produits$: Observable<produit[]>; 
  panierUtilisateur: panier;
  
  constructor(private panierService: PanierService) { }

  ngOnInit(): void {
	this.panierUtilisateur$ = this.appelApi$.pipe(
		switchMap(() => this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any)));
	this.showPanier$ = this.panierUtilisateur$.pipe(map(data => data != null && data.produits.length > 0));
	this.produits$ = this.panierUtilisateur$.pipe(map(pan => pan.produits));




	//TODO appeler panierService avec l'id de l'utilisateur connect�
	/*this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any).subscribe(
		data => {
			console.log(data)
			this.panierUtilisateur = data;
			 if (this.panierUtilisateur != null && this.panierUtilisateur.produits.length > 0) {
				this.showPanier$ = true as any;
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
			console.log("Le produit a �t� supprim� du panier");
			this.appelApi$.next(undefined);
		}));
   }

   vider() {
	  if(confirm("Voulez-vous vraiment vider le panier ?")) {
		
		this.subscriptions.push(this.panierService.viderPanier(this.panierUtilisateur.id)
		.subscribe(unused => {
				console.log("Le panier a �t� vid�");
				this.appelApi$.next(undefined);
			}));
		}
   }

	ngOnDestroy() {
		this.subscriptions.forEach( sub => sub.unsubscribe());
	}
}
