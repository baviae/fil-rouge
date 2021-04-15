import { Component, OnDestroy, OnInit } from '@angular/core';
import { panier } from '../Models/panier';
import { PanierService } from '../services/panier.service';
import { Observable, BehaviorSubject, Subscription } from 'rxjs';
import { map, switchMap, tap } from 'rxjs/operators';
import { produit } from '../Models/produit';
import { ProduitServiceService } from '../services/produit-service.service';
import { imageProduit } from '../Models/imageProduit';

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
  
  constructor(private panierService: PanierService, private produiserv: ProduitServiceService) { }

  ngOnInit(): void {
	this.panierUtilisateur$ = this.appelApi$.pipe(
		switchMap(() => this.panierService.getPanierUtilisateur(localStorage.getItem('id') as any)));
	this.produits$ = this.panierUtilisateur$.pipe(map(pan => pan.produits))
	.pipe(tap(prd => prd.forEach(prdex => this.subscriptions.push(this.produiserv.getImagePrd(prdex.id+'',prdex.image)
	.subscribe(
		data2 => {
			const reader = new FileReader();
			reader.readAsDataURL(data2 as Blob);
			reader.onload = (_event) => {
				prdex.imagePrd = new imageProduit();
				prdex.imagePrd.imagePatch = reader.result;
			}}
	)))));;
	this.showPanier$ = this.produits$.pipe(map(list => list != null && list.length > 0));
	this.subscriptions.push(this.panierUtilisateur$.subscribe(
		data => {
			console.log(data)
			this.panierUtilisateur = data;
	}));

  }

  supprimer(idPrd:number){
	this.subscriptions.push(this.panierService.supprimerProduit(idPrd,this.panierUtilisateur.id)
		.subscribe(unused => {
			console.log("Le produit a ete supprime du panier");
			this.appelApi$.next(undefined);
		}));
   }

   vider() {
	  if(confirm("Voulez-vous vraiment vider le panier ?")) {
		this.subscriptions.push(this.panierService.viderPanier(this.panierUtilisateur.id)
		.subscribe(unused => {
				console.log("Le panier a ete vide");
				this.appelApi$.next(undefined);
			}));
		}
   }

   valider() {
	  this.subscriptions.push(this.panierService.viderPanier(this.panierUtilisateur.id)
	  .subscribe(unused => {
			  alert("Le panier a ete valider avec succes")
			  this.appelApi$.next(undefined);
		  }));
 }

	ngOnDestroy() {
		this.subscriptions.forEach( sub => sub.unsubscribe());
	}
}
