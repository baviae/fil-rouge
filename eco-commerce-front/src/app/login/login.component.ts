import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { utilisateur } from '../Models/utilisateur';
import { ConnecterService } from '../services/connecter.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:utilisateur;
  constructor(private loginService: LoginService, private router:Router, private connecterService: ConnecterService) { }

  ngOnInit(): void {
    this.user = new utilisateur();
  }

  login(){
    this.loginService.gettoken(this.user).subscribe(
      data  => {
        console.log(data.token)
        localStorage.setItem('token',data.token);
        localStorage.setItem('email',data.email);
        this.connecterService.testLogged();
     
        this.router.navigateByUrl('/');
        
      }
    )
    
  }

  ngOnDestroy() {
    location.reload()
  }


}
