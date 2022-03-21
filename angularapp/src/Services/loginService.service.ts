import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http'
import { User } from '../app/signup/User.payload';
import { UserLogin } from '../app/login/user-login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) { 
  }
  public LoginUser(login:UserLogin):Observable<any>
  {
    return this.http.post<UserLogin>("https://8080-addaafdafcfdfcbaaeddadfaadaeaacdfed.examlyiopb.examly.io/isUserPresent",login);  
  }
  public saveUser(user : User):Observable<any>
  {
     return this.http.post<User>("https://8080-addaafdafcfdfcbaaeddadfaadaeaacdfed.examlyiopb.examly.io/saveUser",user)
  }
}
