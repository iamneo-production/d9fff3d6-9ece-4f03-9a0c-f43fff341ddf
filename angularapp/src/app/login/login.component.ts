import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
// import { error } from 'console';
import { SignupService } from '../signup.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // credentials={
  //   username:'',
  //   password:''
  // }

   user=new User();
   msg="";

  constructor(private _service: SignupService ,private _router: Router) { }

  ngOnInit(): void {
  }


  loginUser(){
    // if((this.user.userName !='' && this.user.password != '') && (this.user.userName != null && this.user.password != null)){
    //     //token generate
    //   this._service.generateToken(this.user).subscribe(
    //     (response:any)=>{
    //       //if success
    //       console.log(response.token);
    //       this._service.loginuser(response.token)
    //       window.location.href="/loginsuccess"
    //     },
    //    error=>{
    //      //if error
    //      console.log(error);
    //    }
       

    //   )
    // }
    // else{

    // }


   this._service.loginUserFromRemote(this.user).subscribe(
     data =>{
       console.log("response has been recived");
       this._router.navigate(['/usersuccess']);
      },
     error => {
       console.log("Exception has Occured")
       this.msg="Bad Credential Please enter valid emailId and password";
     }
   )
  }
  gotosignup(){
    this._router.navigate(['/signup']);
  }

}