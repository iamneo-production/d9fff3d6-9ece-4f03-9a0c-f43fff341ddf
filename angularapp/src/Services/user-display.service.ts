import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loanmodel } from 'src/app/loanmodel';

@Injectable({
  providedIn: 'root'
})
export class UserDisplayService {
  private usersUrl: string;
  private usersurl1: string;
  private approve : string;
  private reject : string;


  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/displaycustomers';
    this.usersurl1='http://localhost:8080/editCus';
    this.approve="http://localhost:8080/approve";
    this.reject="http://localhost:8080/reject";
  }
  getEmployeesList(): Observable<Loanmodel[]> {
    return this.http.get<Loanmodel[]>(`${this.usersUrl}`);
  }
  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.usersUrl}/${id}`, { responseType: 'text' });
  }
  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.usersUrl}/${id}`);
  }
  approveCustomer(id:number): Observable<any>
  {
    return this.http.get(`${this.approve}/${id}`); 
  }
  rejectCustomer(id:number): Observable<any>
  {
    return this.http.get(`${this.reject}/${id}`); 
  }
  editCustomer(id:number, value: any): Observable<Object>
  {
    return this.http.put(`${this.usersurl1}/${id}`,value);
  }
  
}
