import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from '../service/login.service';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private service : LoginService){}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

     let newReq = req;
     let token =  this.service.getToken();
     console.log("INTERSEPTOR TOKEN --->" + token)

     if(token!=null){
      newReq= newReq.clone({setHeaders:{authorization:`Bearer ${token}`}})
     }

     console.log("Request after Interseptor " + newReq)
    //  console.log("Request after Interseptor",newReq)
       return next.handle(newReq);
      



  }
}
