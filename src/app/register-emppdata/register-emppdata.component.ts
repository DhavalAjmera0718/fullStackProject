import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-emppdata',
  templateUrl: './register-emppdata.component.html',
  styleUrls: ['./register-emppdata.component.css']
})
export class RegisterEmppdataComponent  implements OnInit{
  
  empData:any;
  imageSelected=false;
  constructor(private service : EmployeeService , private router:Router , private fb:FormBuilder)
  {
    this.empData = this.fb.group({
      empId: ['' , Validators.required],
      email: ['' , Validators.email],
      image: ['' , Validators.required],
      empName: ['' , Validators.required],
      contact: ['',Validators.required],
      city: [''  , Validators.required], 
      achivements: ['', Validators.required] 
    })


  }
  
  
  ngOnInit(): void {
    
  }

SaveData()
{
  this.service.SaveEmpData(this.empData.value).subscribe(
    {
      next:(resp)=>
      {
        this.empData=resp;
        alert("Employee Data Has been Saved ")
        this.router.navigate(['home'])
      },
      error:(err)=>
      {
        alert("Please Try Again..!!")
      }
    }
  )
}
onFileSelected(event: any): void {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.empData.get('image').setValue(e.target.result); // Set image data to form control
    };
    reader.readAsDataURL(file);
  }
}



get empId()
{
  return this.empData.get('empId')
}

}
