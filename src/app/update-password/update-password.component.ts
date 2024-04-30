import { Component ,OnInit} from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {
  
  
updatePassData:any;

  constructor( private loginservice : LoginService , private router :Router , private fb : FormBuilder)
  {

    this.updatePassData =  this.fb.group({
      password:['' , Validators.minLength(8)],
      username:['' , Validators.required],
    })

  }
  
  ngOnInit(): void {
   
  }

  UpdatePasswordByUsername()
  {
    alert("run");
   this.loginservice.updatePassword(this.updatePassData.value.username , this.updatePassData.value.password ).subscribe({
    next:(resp)=>{
      // if(resp==='Password Hase Been Changed'){
        alert("Password Updated Successfully!")
        this.router.navigate(['login'])
        
      // }
    },
    error:(err)=>{
      alert(err);
    }
   })

  
}


get password()
{
  return this.updatePassData.get('password')
}
get reEnterPassword()
{
  return this.updatePassData.get('reEnterPassword')
}
get username()
{
  return this.updatePassData.get('username')
}

}
