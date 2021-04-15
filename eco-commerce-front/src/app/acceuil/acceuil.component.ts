import { Byte } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { imageProduit } from '../Models/imageProduit';
import { produit } from '../Models/produit';
import { utilisateur } from '../Models/utilisateur';
import { ConnecterService } from '../services/connecter.service';
import { ListeUserService } from '../services/liste-user.service';
import { ProduitServiceService } from '../services/produit-service.service';
import { UsersConnecteServiceService } from '../services/users-connecte-service.service';
import { PanierService } from '../services/panier.service';


@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.css']
})
export class AcceuilComponent implements OnInit {

  title = 'eco-commerce-front';
  logger = false;
  refreshed = false;
  previousUrl: string;
  mail:any;
  user:utilisateur;
  image:Byte[];
  produitsList:produit[];
  
  constructor(private listeUserService: ListeUserService,
     public connecterService: ConnecterService, private router: Router, public activatedRoute: ActivatedRoute,
     public usersConnecteServiceService:UsersConnecteServiceService, private produiserv: ProduitServiceService, public panierserv: PanierService) {
       
     }

     ngOnInit(): void {
      this.produiserv.getListeProduit().subscribe( data => {
        this.produitsList = data as produit[];
        this.produitsList.forEach(element => {
          if(element.image){
          this.produiserv.getImagePrd(element.id+'', element.image).subscribe(
            data2 => {
              const reader = new FileReader();
              reader.readAsDataURL(data2 as Blob);
              reader.onload = (_event) => {
                element.imagePrd = new imageProduit();
                element.imagePrd.imagePatch = reader.result;
              }
            }
          );
          }
        });
        console.log(this.produitsList);
      })
    }

	ajoutPan(id:number) {
		this.panierserv.ajoutdansPanier((localStorage.getItem('id') as any), id).subscribe(
      unused => {
        alert("Le produit a ete ajouté avec succes au panier");
      }
    );
		console.log((localStorage.getItem('id') as any));
	}
}

