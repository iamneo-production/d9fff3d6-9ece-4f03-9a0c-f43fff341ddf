import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplyLoanComponent } from './apply-loan/apply-loan.component';

const routes: Routes = [
  {
    path:"",redirectTo:"user/applyLoan",pathMatch:"full"
  },
  {
    path:"user/applyLoan" , component:ApplyLoanComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
