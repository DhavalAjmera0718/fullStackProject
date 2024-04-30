import { Component , OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-employee-data',
  templateUrl: './home-employee-data.component.html',
  styleUrls: ['./home-employee-data.component.css']
})
export class HomeEmployeeDataComponent implements OnInit {



  employees:any;
  id:any;
  
  constructor(private empservice : EmployeeService , private router: Router)
  {}
  ngOnInit(): void {

    this.empservice.getAllEmpData().subscribe({
      next:(resp)=>
      {
        this.employees=resp;
        console.log(resp)
      },
      error:(err)=>{
        alert(err)
      }
    })
    
  }
  
  updateEmpdataRoute(id:any)
  {
    this.router.navigate([`updateEmp`,id])
  }
}
