import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  


  otpdata:any;

  constructor(private loginservice:LoginService , private fb : FormBuilder , private router :Router)
  {
    this.otpdata = this.fb.group({
      email:['' ,Validators.email ],
      dob:['' , Validators.required]
    })
  }
  
  ngOnInit(): void {
  

  }

  onSubmit(){
    this.loginservice.genrateOtp(this.otpdata.value.email , this.otpdata.value.dob).subscribe({
      next:(resp)=>{
        alert("Otp Has Been Sent to -" + this.otpdata.value.email)
        this.router.navigate(['verifyotp'] ,{
          queryParams:{
            email:this.otpdata.value.email,
            dob:this.otpdata.value.dob
          }
        })
      },
      error:(err)=>{
        alert("Please check your details again Your Entered email is --->|" + this.otpdata.value.email + " and Date Of Birth is --->| " + this.otpdata.value.dob)
      }
    })

  }



  get email()
  {
    return this.otpdata.get('email')
  }
}
