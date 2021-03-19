import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, ParamMap, Router, RoutesRecognized } from '@angular/router';
import { produit } from './Models/produit';
import { utilisateur } from './Models/utilisateur';
import { ConnecterService } from './services/connecter.service';
import { ListeUserService } from './services/liste-user.service';
import { ProduitServiceService } from './services/produit-service.service';
import { UsersConnecteServiceService } from './services/users-connecte-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
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
    console.log();
    this.usersConnecteServiceService.getUser().subscribe(data => {
      this.user = data
      if (this.user.id !== undefined || localStorage.getItem('token')){
        this.logger = true;
        if (this.user.id !== undefined) {
          this.mail = this.user.email;
        }else {
          this.mail = localStorage.getItem('email');
        }
      } else {
        this.mail = '';
        this.logger = false;
      }
    }); 
  }

  show(){
    this.listeUserService.getListe().subscribe(
      data =>{ console.log(data);}
    )
  }

  logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('email');
    this.logger = false;
    this.mail = '';
    this.router.navigate(['/login'])
    this.user = null;
  }


}
