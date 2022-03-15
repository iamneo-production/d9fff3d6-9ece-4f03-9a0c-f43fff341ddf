import { Injectable } from '@angular/core';
import { Loan , Document } from './loan';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
 
  constructor(private http: HttpClient) { }

  public uploadDocument(doc:Document):Observable<any>
  {
  return this.http.post("http://localhost:8080/uploadDocument",doc,{ observe: 'response' });
  }
  public applyLoan(loan:Loan):Observable<any>
  {
    return this.http.post<Loan>("http://localhost:8080/applyLoan",loan,{observe:'response'});
  }
}
