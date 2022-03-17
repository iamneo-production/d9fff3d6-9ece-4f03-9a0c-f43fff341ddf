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

const routes: Routes = [{path:'',component:LoginComponent},{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},{path:'admin',component:AdminComponent},
{ path: 'adminappliedloan', component: AdminappliedloanComponent },
{ path: 'adminapprovedloan', component: AdminapprovedloanComponent },
{path:'details/:id',component:CustomerDetailComponent},
{path:'edit/:id',component:CustomerEditComponent},
{path:'searchdetail/:id',component:SearchCustomerComponent},
//UPDATE `topup_loan`.`loan_model` SET `loan_id` = '123459', `repayment_months` = '24', `applicant_aadharr` = '345678997', `applicant_address` = '2/78,loasn', `applicant_email` = 'applicant12@gmail.com', `applicant_mobile` = '999999989', `applicant_name` = 'test29', `applicant_pan` = '234548567', `applicant_salary` = '2337445', `loantype` = 'test2', `apprej` = 'rej' WHERE (`loan_id` = '123456');  
//INSERT INTO `topup_loan`.`loan_model` (`loan_id`, `repayment_months`, `applicant_aadharr`, `applicant_address`, `applicant_email`, `applicant_mobile`, `applicant_name`, `applicant_pan`, `applicant_salary`, `loan_amount_required`, `loantype`, `apprej`) VALUES ('1234', '34', '343', 'lop', 'apply@gmail.com', '888888888', 'test45', '596806', '4875948', '38478349', 'test4', 'app');
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule{}