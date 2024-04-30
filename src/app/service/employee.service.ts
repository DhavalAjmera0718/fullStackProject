import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

empUrl = "http://localhost:7004/emp/"

  constructor(private httpclient :HttpClient ) 
  { }



  
getAllEmpData()
{
  return this.httpclient.get(this.empUrl + "GetAllEmp_Data" , {responseType : 'json'})
}

getEmpData_Byid(id:any)
{
  return this.httpclient.get(this.empUrl + "get-emp-byid/"+id , {responseType : 'json'})

}

UpdateAdminById(id:any , postdata:any)
 {
  return this.httpclient.post(this.empUrl+"update/"+id , postdata , {responseType : 'text'})
 }


SaveEmpData(data:any)
{
  return this.httpclient.post(this.empUrl+"SaveEmployee_Data" , data , {responseType : 'text'})
}


DeleteEmpByID(id:any)
{
  return this.httpclient.get(this.empUrl+"delete-empdata-byid/" + id , {responseType : 'text'})
}

}
