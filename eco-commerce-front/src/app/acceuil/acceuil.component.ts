import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { produit } from '../Models/produit';
import { utilisateur } from '../Models/utilisateur';
import { ConnecterService } from '../services/connecter.service';
import { ListeUserService } from '../services/liste-user.service';
import { ProduitServiceService } from '../services/produit-service.service';
import { UsersConnecteServiceService } from '../services/users-connecte-service.service';

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
  produitsList:produit[];
  constructor(private listeUserService: ListeUserService,
     public connecterService: ConnecterService, private router: Router, public activatedRoute: ActivatedRoute,
     public usersConnecteServiceService:UsersConnecteServiceService, private produiserv: ProduitServiceService) {
       
     }

     ngOnInit(): void {
      this.produiserv.getListeProduit().subscribe( data => {
        this.produitsList = data as produit[];
        console.log(this.produitsList);
      })
    }
}
