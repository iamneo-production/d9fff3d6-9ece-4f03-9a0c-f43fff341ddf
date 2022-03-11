import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { SignupService } from '../signup.service';
import { User } from '../user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user=new User();
  msg="";

  constructor(private _service: SignupService ,private _router: Router) { }


  ngOnInit(): void {
  }

  signupUser(){
    this._service.signupUserFromRemote(this.user).subscribe(
      data =>{
        console.log("response has been recived");
        // this.msg=("Registration Successful");
        this._router.navigate(['/login']);
       },
      error => {
        console.log("Exception has Occured")
        this.msg="User Already Exist";
      }
    )
  }

}
