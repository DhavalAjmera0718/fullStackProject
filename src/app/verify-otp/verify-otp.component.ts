import { Component  , OnInit} from '@angular/core';
import { LoginService } from '../service/login.service';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-verify-otp',
  templateUrl: './verify-otp.component.html',
  styleUrls: ['./verify-otp.component.css']
})
export class VerifyOtpComponent  implements OnInit{
  
formdata:any;

  constructor( private loginservice :  LoginService , private fb : FormBuilder ,
     private activatedRouter : ActivatedRoute , private router : Router )
  {
    this.activatedRouter.queryParams.subscribe(params=>
      {
        const emailData =  params['email']
        const dobData = params['dob']

        this.formdata = this.fb.group({
          email:[emailData , Validators.email],
          otp:['' , Validators.maxLength(4)],
          dob:[dobData , Validators.required]
        })

      })
  }
  
  
  
  ngOnInit(): void {
    
  }
  
  verifyOtp() {
    this.loginservice.verifyOtp(this.formdata.value.email, this.formdata.value.otp, this.formdata.value.dob).subscribe(
      data => {
        alert("Please Check Your Registered Mail....!!!")
        console.log(data);
        this.router.navigate(['login'])
      },
      err => {
        console.log(err);
      }

    )
  }
  getForgotLink() {
    this.loginservice.verifyOtp(this.formdata.value.email, this.formdata.value.otp, this.formdata.value.dob).subscribe(
      data => {
        alert("Link Has Been Sent to to Your Registered Mail....!!!")
        console.log(data);
        this.router.navigate(['login'])
      },
      err => {
        console.log(err);
      }

    )
  }




  
}
