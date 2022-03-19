import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule ,ReactiveFormsModule}   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginService } from '../Services/loginService.service';
import { RouterTestingModule } from '@angular/router/testing';
import { AdminComponent } from './admin/admin.component';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { UserNavComponent } from './user-nav/user-nav.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    AdminComponent,
    AdminapprovedloanComponent,
    AdminappliedloanComponent,
    CustomerDetailComponent,
    CustomerEditComponent,
    AdminNavbarComponent,
    SearchCustomerComponent,
    UserNavComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterTestingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
//npm install --save @angular/material