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
  files: File;
  produit:produit;
  imagePath;
  imgURL: any;
  constructor(private produitServ:ProduitServiceService, private router:Router) { }

  ngOnInit(): void {
    this.produit = new produit();
  }

  save(){
    this.produitServ.saveProduit(this.produit).subscribe(
      data => {
          this.isAjouter = true;
          this.sendImgProduit((data as produit).id);
      }
    );
    this.produit = new produit();
  }

  onFocus(){
    this.isAjouter = false;
  }

    // tslint:disable-next-line:typedef
    _onFilesChanged(event) {
      console.log(event[0]);
      this.files = event[0];
      var reader = new FileReader();
      this.imagePath = event;
      reader.readAsDataURL(event[0]); 
      reader.onload = (_event) => { 
        this.imgURL = reader.result; 
      }
    }
  
    // tslint:disable-next-line:typedef
    testfile(){
      console.log(this.files);
    }

    sendImgProduit(id:number){
      if(this.files){
        console.log(this.files)
        this.produitServ.pushFileToStorage(id,this.files).subscribe();
      }
    }
}
