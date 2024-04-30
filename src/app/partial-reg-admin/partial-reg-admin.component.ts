import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-partial-reg-admin',
  templateUrl: './partial-reg-admin.component.html',
  styleUrls: ['./partial-reg-admin.component.css']
})
export class PartialRegAdminComponent {

  empData:any;
  constructor(private loginservice: LoginService , private router:Router , private fb : FormBuilder)
  {
    this.empData = this.fb.group({
      name:['' , Validators.required],
      email:['' , Validators.email],
      password:['' , Validators.minLength(6)],
    })

  }
  ngOnInit(): void {
  
  }

/***************************************************[ Register Admin]************************************************************ */
registerAdmin()
{
  this.loginservice.RegisterAdmin(this.empData.value).subscribe({
    next:(resp)=>{
      // this.empData=resp;
      console.log(resp)
      alert("Login Successful....!!")
      this.router.navigate(['login'])
      // location.reload()
    },
    error:(err)=>
    {
      alert("Please Try Again")
    }
  })
}



get name()
   {
     return this.empData.get('name')
   } 
   get email()
   {
     return this.empData.get('email')
   } 
   get password()
   {
     return this.empData.get('password')
   } 
}
