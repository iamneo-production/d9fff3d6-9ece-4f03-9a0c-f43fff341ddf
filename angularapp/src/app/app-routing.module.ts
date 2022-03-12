import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdminappliedloanComponent } from './adminappliedloan/adminappliedloan.component';
import { AdminapprovedloanComponent } from './adminapprovedloan/adminapprovedloan.component';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import { LoginComponent } from './login/login.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},{path:'admin',component:AdminComponent},
{ path: 'adminappliedloan', component: AdminappliedloanComponent },
{ path: 'adminapprovedloan', component: AdminapprovedloanComponent },
{path:'details/:id',component:CustomerDetailComponent},
{path:'edit/:id',component:CustomerEditComponent},
{path:'searchdetail/:id',component:SearchCustomerComponent},
{path:'',component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule{}
export const routingComponenets=[LoginComponent,SignupComponent]