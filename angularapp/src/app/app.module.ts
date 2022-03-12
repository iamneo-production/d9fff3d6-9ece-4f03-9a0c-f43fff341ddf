import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule ,ReactiveFormsModule}   from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { routingComponenets } from './app-routing.module';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LoginService } from '../Services/loginService.service';
import { RouterTestingModule } from '@angular/router/testing';
import { AdminComponent } from './admin/admin.component';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchCustomerComponent } from './search-customer/search-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponenets,
    AdminComponent,
    AdminapprovedloanComponent,
    AdminappliedloanComponent,
    CustomerDetailComponent,
    CustomerEditComponent,
    AdminNavbarComponent,
    SearchCustomerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterTestingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
