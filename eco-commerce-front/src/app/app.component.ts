import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, ParamMap, Router, RoutesRecognized } from '@angular/router';
import { ConnecterService } from './services/connecter.service';
import { ListeUserService } from './services/liste-user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'eco-commerce-front';
  logger:any;
  refreshed = false;
  previousUrl: string;
  mail:any;
  constructor(private listeUserService: ListeUserService,
     public connecterService: ConnecterService, private router: Router, public activatedRoute: ActivatedRoute) {
       
     }

  ngOnInit(): void {
    if (localStorage.getItem('token')){
      this.logger = true;
     
      this.mail = localStorage.getItem('email');
    } else {
      this.mail = '';
    }
    
  }


  refresh(): void {
    window.location.reload();
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

  }


}
