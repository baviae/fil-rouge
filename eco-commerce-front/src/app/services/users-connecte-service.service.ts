import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { utilisateur } from '../Models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UsersConnecteServiceService {
  user = new BehaviorSubject<utilisateur>(new utilisateur());
  curUser = this.user.asObservable();
  constructor() { }

  addUser(us:utilisateur){
    this.user.next(us);
  }

  getUser(){
    return this.user;
  }


}
