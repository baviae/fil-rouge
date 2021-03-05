import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenhandlerforhttpreqService implements HttpInterceptor{

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log("httpInterceptor.......")
    if (!localStorage.getItem('token')){
        return next.handle(req);
    } else {
      let request = req.clone({
        setHeaders:{  
          Authorization: localStorage.getItem('token')
        }
      })
      return next.handle(request);
    }
  }

}
