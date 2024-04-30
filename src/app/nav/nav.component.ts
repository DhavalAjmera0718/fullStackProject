import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  public loggedin = false;

  constructor(private service: LoginService , private router:Router){}
  ngOnInit(): void {
  this.loggedin=this.service.isLoggedIn()
  console.log( "Login condition--->" , this.loggedin)
  // window.location.reload()
    
  }

  isStudentListPath(): boolean {
    return this.router.url.includes('studentlist');
  }

 isAdminListIsOpen()
 {
  return this.router.url.includes('getadmin')
 } 
  
LogoutUser(){
  this.service.LogOut()
  this.router.navigate(['/login'])
  

}

}
