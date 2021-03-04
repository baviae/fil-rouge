import { Component, OnInit } from '@angular/core';
import { utilisateur } from 'app/Models/utilisateur';
import { LoginService } from 'app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user:utilisateur;
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.user = new utilisateur();
  }

  login(){
    this.loginService.gettoken(this.user).subscribe(
      data => console.log(data)
    )
    
  }

}
