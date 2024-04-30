  import { Component, OnInit } from '@angular/core';
  import { EmployeeService } from '../service/employee.service';
  import { ActivatedRoute, Router } from '@angular/router';
  import { MatDialog } from '@angular/material/dialog';
  import { DailogUpdateAdminComponent } from '../dailog-update-admin/dailog-update-admin.component';
  import { MatTableDataSource } from '@angular/material/table';
  import { LoginService } from '../service/login.service';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

  @Component({
    selector: 'app-update-empdata',
    templateUrl: './update-empdata.component.html',
    styleUrls: ['./update-empdata.component.css']
  })
  export class UpdateEmpdataComponent implements OnInit {
  
    
    id:any;
    
    Empdata : any
    dataSource:any;
    constructor(private service:EmployeeService , private loginservice:LoginService , private route :Router ,
      private activatedRoute : ActivatedRoute , public dialog: MatDialog){}
    
    ngOnInit(): void {
    
      this.id = this.activatedRoute.snapshot.params['id']
      this.service.getEmpData_Byid(this.id).subscribe(data => {
        this.Empdata=data;
        console.log(data)
      })

      this.getRole();
    }
  
  
    onSubmit(){
      this.service.UpdateAdminById(this.id , this.Empdata).subscribe(data=>{
        alert("Admin Data Hase Been Updated ")
        this.gotoAdminnlist();
      })
    }

    gotoAdminnlist(){
      this.route.navigate([`home`])
    }


  /*****************************************[ UPDATE DAILOG BOX]**************************************************************************/
  openDialog(width: string, height: string, email: string): void {
    const dialogRef = this.dialog.open(DailogUpdateAdminComponent, {
      width: width,
      height: height,
      data: { email: email }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.service.getAllEmpData().subscribe({
        next: (resp) => {
          this.Empdata = resp;
          console.log( 'FROM DAILOG CLOSE----> ' , this.Empdata)
          this.dataSource = new MatTableDataSource(this.Empdata);
          location.reload()
          // this.dataSource.paginator = this.paginator;
          // this.dataSource.sort = this.matsort;
          // this.dataSource.form=this.matform
          console.log("Data Source--->", this.dataSource)

        },
        error: (err) => {
          console.log(err);
        }
      })
      // You can handle the result here if needed
    });
  }
  /********************************************************************[ DISABLE DELETE BUTTON]*****************************************************************************************/
  flag:boolean=false;
  getRole() {
    const role=localStorage.getItem('role');
    console.log(role)
    if(role==='ROLE_ADMIN'){
      this.flag=!this.flag
    }
  }


  // DeleteEmpById()
  // {

  // const confirmDelete = confirm("Are You sure you want delete this data ?")
  // if(confirmDelete){

  //   this.service.DeleteEmpByID(this.id).subscribe({
  //     next:(resp)=>
  //     {
  //       alert("Employee Has Been Deleted")
  //       this.route.navigate(['home'])
  //       // location.reload()
  //     }
  //   })
  // }
  // }
  DeleteEmpById() {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '300px',
      data: "Are you sure you want to delete this employee?"
    });
  
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.service.DeleteEmpByID(this.id).subscribe({
          next: (resp) => {
            console.log("Employee Has Been Deleted", resp);
            this.route.navigate(['home']);
            // Optionally, avoid using location.reload()
          },
          error: (error) => {
            console.error("Error deleting employee:", error);
          }
        });
      }
    });
  }
  

  }
