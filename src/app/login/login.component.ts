import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  
  userdata = {
    username: '',
    password: ''
  }
  tableData: any;
  reactiveForm: any;

  constructor(private service: LoginService, private fb: FormBuilder, private router: Router) {

    this.reactiveForm = this.fb.group({
      username: [],
      password: []

    })
  }
  ngOnInit(): void {

  }

  onSubmit() {
    if ((this.userdata.username != '' && this.userdata.password != '') && this.userdata.username != null && this.userdata.password != null) {
      console.log("Data Hase been Submited")
      this.service.TokenGeneration(this.userdata).subscribe(
        (response: any) => {
          console.log(response.jwtToken)
          // console.log(response)
          const payload =  this.service.LoginUser(response.jwtToken)
          alert(payload)
          if(payload.authorities==="ROLE_ADMIN")
          {
            this.router.navigate(['home'])
          }
          else if(payload.authorities==="ROLE_USER"){
            this.router.navigate(['home'])
          }
          

        },
        (err:any)=>
        {
          alert(err)
        }
      )

    }
    else {
      alert("Invalid Userid Password...!! ")
    }
  }



}
