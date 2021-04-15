import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { utilisateur } from '../Models/utilisateur';
import { ConnecterService } from '../services/connecter.service';
import { LoginService } from '../services/login.service';
import { UsersConnecteServiceService } from '../services/users-connecte-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:utilisateur;
  constructor(private loginService: LoginService, private router:Router, private connecterService: ConnecterService,
    public usersConnecteServiceService:UsersConnecteServiceService) { }

  ngOnInit(): void {
    this.user = new utilisateur();
  }

  login(){
    this.loginService.gettoken(this.user).subscribe(
      data  => {
        
        this.usersConnecteServiceService.addUser( data as utilisateur);
        console.log(data as utilisateur);
        localStorage.setItem('user',data);
        localStorage.setItem('token',data.token);
        localStorage.setItem('email',data.email);
		    localStorage.setItem('id',data.id);
        this.connecterService.testLogged();
        this.router.navigateByUrl('/');
      }
    )
    
  }

  //ngOnDestroy() {
   // location.reload()
  //}


}
