import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loanmodel } from 'src/app/loanmodel';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
 
  private profile:string;
  private usersurl1:string;
  private usersUrl:string;
  constructor(private http: HttpClient) {
    this.profile='https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/getProfile';
    this.usersurl1='https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/editCus';
    this.usersUrl = 'https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/displaycustomer';

  }
  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.usersUrl}/${id}`);
  }
  getProfile(id: string):Observable<any>{
     return this.http.get(`${this.profile}/${id}`);
  }
  editCustomer(id:number, value: any): Observable<Object>
  {
    return this.http.put(`${this.usersurl1}/${id}`,value);
  }
  
}
