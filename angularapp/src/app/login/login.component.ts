import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../Services/loginService.service';
import { UserLogin } from './user-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginuser: UserLogin;
  public static id:string;


  constructor( 
      private router: Router, 
        private registationService: LoginService,private formbuilder: FormBuilder) {
          this.loginuser = new UserLogin();
  }
  onSubmit(){
    if(this.loginuser.email==="admin" && this.loginuser.password==="admin")
    { LoginComponent.id=this.loginuser.email;
      this.router.navigate(['/admin']);
    }
    else
    {
         this.registationService.LoginUser(this.loginuser).subscribe(data=>{
         if(data===true)
          { LoginComponent.id=this.loginuser.email;
               this.router.navigate(['/user']);
           }
          else if(data===false)
            {
              alert("Wrong Username or Password");
          
            }
          });
      }
 
  }
  emailRegex = "";
passwordRegex =""; 
LoginForm = this.formbuilder.group({
    email: ['',[Validators.required,Validators.pattern(this.emailRegex)]],
    password:['',[Validators.required,Validators.pattern(this.passwordRegex)]]  
  }); 
 /* get email(){
    return this.LoginForm.get('email');
  }
  get emailcontrols(){
    return this.LoginForm.controls['email'].errors;
  }
  get password(){
    return this.LoginForm.get('password');
  }
  get passwordcontrols(){
    return this.LoginForm.controls['password'].errors;
  }
 /* gotoLoginList() {
    alert("Suceessfully LoggedIn");
    this.router.navigate(['/']);
  }*/ 
    
  ngOnInit(): void {
  }

}
