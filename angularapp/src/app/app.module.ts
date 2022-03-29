import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { FormsModule ,ReactiveFormsModule}   from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { LoginService } from '../Services/loginService.service';
import { RouterTestingModule } from '@angular/router/testing';
import { AdminComponent } from './admin/admin.component';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { UserNavComponent } from './user-nav/user-nav.component';
import { UserApplyLoanComponent } from './user-apply-loan/user-apply-loan.component';
import { UserUploadDocumentComponent } from './user-upload-document/user-upload-document.component';
import { UserComponent } from './user/user.component';
import { UserLoanstatusComponent } from './user-loanstatus/user-loanstatus.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    UserApplyLoanComponent,
    UserUploadDocumentComponent,
    SignupComponent,
    LoginComponent,
    AdminComponent,
    AdminapprovedloanComponent,
    AdminappliedloanComponent,
    CustomerDetailComponent,
    CustomerEditComponent,
    AdminNavbarComponent,
    SearchCustomerComponent,
    UserNavComponent,
    UserComponent,
    UserLoanstatusComponent,
    UserSearchComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterTestingModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
