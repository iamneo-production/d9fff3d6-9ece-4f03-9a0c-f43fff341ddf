import { Injectable } from '@angular/core';
import { Loan , Document } from './loan';
import { Observable } from 'rxjs';
import {HttpClient, HttpEvent} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
 
  constructor(private http: HttpClient) { }

  public uploadDocument(doc:Document):Observable<HttpEvent<any>>
  {
  return this.http.post<any>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/uploadDocument",doc);
  }
  public applyLoan(loan:Loan):Observable<any>
  {
    return this.http.post<any>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/applyLoan",loan);
  }
}
