import { Component, Inject } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-dailog-update-admin',
  templateUrl: './dailog-update-admin.component.html',
  styleUrls: ['./dailog-update-admin.component.css']
})
export class DailogUpdateAdminComponent {

  id: any
  empData: any={};
  constructor(private service: EmployeeService, private activatedRoute: ActivatedRoute, private router : Router, public dialogRef: MatDialogRef<DailogUpdateAdminComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

    onClose(): void {
      this.dialogRef.close();
    }
 
  ngOnInit(): void {
    this.id = this.data.email;
    this.service.getEmpData_Byid(this.id).subscribe(
      (resp) => {
        // alert("resp--->" + resp)
        this.empData = resp;
        console.log(resp);
      },
      (error) => console.log(error)
    );
  }

  
  onSubmit()
  {
    this.service.UpdateAdminById(this.id , this.empData).subscribe( data2 => {
      alert("Data has been Updated")
      this.router.navigate(['updateEmp',this.id]);
      // this.onClose();
      // window.location.reload()
    })
  }
 
  onFileSelected(event: any): void {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.empData.image = e.target.result; // Sets image preview
      };
      reader.readAsDataURL(file); // Reads file as data URL and triggers `onload`
    }
  }


 
}
