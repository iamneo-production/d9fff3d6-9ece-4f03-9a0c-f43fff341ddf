import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
// import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
// import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { SignupComponent } from './signup/signup.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  // {path:'loginsuccess',component:LoginsuccessComponent,canActivate:[AuthGuard]}, 
  {path:'usersuccess',component:UserdashboardComponent}, 
  {path:'signup',component:SignupComponent},
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }