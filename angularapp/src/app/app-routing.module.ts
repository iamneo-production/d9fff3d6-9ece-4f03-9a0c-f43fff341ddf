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
import { UserLoanstatusComponent } from './user-loanstatus/user-loanstatus.component';
import { UserNavComponent } from './user-nav/user-nav.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserSearchComponent } from './user-search/user-search.component';
import { UserComponent } from './user/user.component';
import { UserApplyLoanComponent } from './user-apply-loan/user-apply-loan.component';

const routes: Routes = [
  { path: '', component: LoginComponent }, 
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent }, 
  { path: 'admin', component: AdminComponent },
  { path: 'adminappliedloan', component: AdminappliedloanComponent },
  { path: 'adminapprovedloan', component: AdminapprovedloanComponent },
  { path: 'details/:id', component: CustomerDetailComponent },
  { path: 'edit/:id', component: CustomerEditComponent },
  { path: 'searchdetail/:id', component: SearchCustomerComponent }, 
  {path:'userdetailsearch/:id',component:UserSearchComponent},
  {path:'user',component:UserComponent},
  {path:'userloanstatus',component:UserLoanstatusComponent},
  {path:'userprofile',component:UserProfileComponent},
  {path:'userapplyloan' , component: UserApplyLoanComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
