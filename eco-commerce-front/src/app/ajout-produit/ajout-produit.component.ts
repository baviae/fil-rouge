import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { produit } from '../Models/produit';
import { ProduitServiceService } from '../services/produit-service.service';

@Component({
  selector: 'app-ajout-produit',
  templateUrl: './ajout-produit.component.html',
  styleUrls: ['./ajout-produit.component.css']
})
export class AjoutProduitComponent implements OnInit {

  isAjouter = false;
  produit:produit;
  constructor(private produitServ:ProduitServiceService, private router:Router) { }

  ngOnInit(): void {
    this.produit = new produit();
  }

  save(){
    this.produitServ.saveProduit(this.produit).subscribe(
      data => {
          this.isAjouter = true;
      }
    );
    this.produit = new produit();
  }

  onFocus(){
    this.isAjouter = false;
  }
}
