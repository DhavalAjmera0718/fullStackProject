import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSliderModule} from '@angular/material/slider';
import {MatSortModule} from '@angular/material/sort';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import { HomeEmployeeDataComponent } from './home-employee-data/home-employee-data.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './intercepror/auth.interceptor';
import { NavComponent } from './nav/nav.component';
import { PartialRegistrationComponent } from './partial-registration/partial-registration.component';
import { UpdateEmpdataComponent } from './update-empdata/update-empdata.component';
import { DailogUpdateAdminComponent } from './dailog-update-admin/dailog-update-admin.component';
import { RegisterEmppdataComponent } from './register-emppdata/register-emppdata.component';
import { PartialRegAdminComponent } from './partial-reg-admin/partial-reg-admin.component';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { VerifyOtpComponent } from './verify-otp/verify-otp.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeEmployeeDataComponent,
    LoginComponent,
    NavComponent,
   
    PartialRegistrationComponent,
        UpdateEmpdataComponent,
        DailogUpdateAdminComponent,
        RegisterEmppdataComponent,
        PartialRegAdminComponent,
        ConfirmDialogComponent,
        ForgotPasswordComponent,
        VerifyOtpComponent,
        UpdatePasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatSliderModule,
    MatSortModule,
    MatCardModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [{provide:HTTP_INTERCEPTORS , useClass:AuthInterceptor , multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
