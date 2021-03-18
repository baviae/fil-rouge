import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, ParamMap, Router, RoutesRecognized } from '@angular/router';
import { utilisateur } from './Models/utilisateur';
import { ConnecterService } from './services/connecter.service';
import { ListeUserService } from './services/liste-user.service';
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
  constructor(private listeUserService: ListeUserService,
     public connecterService: ConnecterService, private router: Router, public activatedRoute: ActivatedRoute,
     public usersConnecteServiceService:UsersConnecteServiceService) {
       
     }

  ngOnInit(): void {
    console.log('ici');
    console.log(this.usersConnecteServiceService.getUser().subscribe(data => {
      this.user = data
      if (this.user.id !== undefined){
        this.logger = true;
        this.mail = this.user.email;
      } else {
        this.mail = '';
        this.logger = false;
      }
    }));

    
  }


  refresh(): void {
   // window.location.reload();
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
