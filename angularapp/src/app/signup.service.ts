import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import {HttpClient} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class SignupService {

  // url="http://localhost:8080"

  constructor(private _http:HttpClient) { }

  


  public loginUserFromRemote(user :User):Observable<any>{
  //  return this._http.post<any>("http://localhost:8080/login",user)
   return this._http.post<any>("https://8080-dafccccadbcbffcbaaeddadfaadaeaacdfed.examlyiopb.examly.io/login",user)
  //  return this._http.post<any>("http://8080-dafccccadbcbffcbaaeddadfaadaeaacdfed.examlyiopb.examly.io//login",user)
  }
  public signupUserFromRemote(user :User):Observable<any>{
    // return this._http.post<any>("http://localhost:8080/signup",user)
    return this._http.post<any>("https://8080-dafccccadbcbffcbaaeddadfaadaeaacdfed.examlyiopb.examly.io/signup",user)
    // return this._http.post<any>("http://8080-dafccccadbcbffcbaaeddadfaadaeaacdfed.examlyiopb.examly.io//signup",user)
   }

  // calling the server to generate token
  // generateToken(user: User){
  //   return this._http.post(`${this.url}/token`,user);
  // }

  // for Login User
  // loginuser(token: string): boolean{
  //   localStorage.setItem("token",token);
  //   return true;
  // }

  // to check that user is login or not
  // isLoggedIn(): boolean{
  //   let token=localStorage.getItem("token");
  //   if(token==undefined || token==='' || token==null){
  //     return false;
  //   }
  //   else{
  //     return true;
  //   }
  // }


  // for logout the user
  // logout(){
  //   localStorage.removeItem('token');
  //   return true;
  // }

  // for getting the token
// getToken(){
//   return localStorage.getItem("token");
// }

}