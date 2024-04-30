import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeEmployeeDataComponent } from './home-employee-data/home-employee-data.component';
import { LoginComponent } from './login/login.component';
import { PartialRegistrationComponent } from './partial-registration/partial-registration.component';
import { UpdateEmpdataComponent } from './update-empdata/update-empdata.component';
import { RegisterEmppdataComponent } from './register-emppdata/register-emppdata.component';
import { PartialRegAdminComponent } from './partial-reg-admin/partial-reg-admin.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { VerifyOtpComponent } from './verify-otp/verify-otp.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { authGuard } from './guard/auth.guard';



const routes: Routes = [
  {
    path:'home',
    component:HomeEmployeeDataComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'forgotpass',
    component:ForgotPasswordComponent
  },
  
  {
    path:'verifyotp',
    component:VerifyOtpComponent
  },
  {
    path:'updatepass',
    component:UpdatePasswordComponent
  },
  
  {
    path:'registerEmp',
    component:PartialRegistrationComponent,
    // canActivate:[authGuard]
  },
  {
    path:'partial-reg-admin',
    component:PartialRegAdminComponent
  },
  
  {
    path:'registerEmpdata',
    component:RegisterEmppdataComponent
  },

  {
    path:'updateEmp',
    component:UpdateEmpdataComponent,
    canActivate:[authGuard]
  },
  {
    path:'updateEmp/:id',
    component:UpdateEmpdataComponent
  },

  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
