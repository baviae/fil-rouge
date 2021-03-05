import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { utilisateur } from '../Models/utilisateur';
import { InscriptionService } from '../services/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  user:utilisateur;
  constructor(private inscriptionService: InscriptionService, private router:Router) { }

  ngOnInit(): void {
    this.user = new utilisateur();
  }


  save(){
    this.inscriptionService.inscrit(this.user).subscribe(
      data =>  this.router.navigateByUrl('/login')
    )
  }

}
