import { Injectable } from '@angular/core';
import { Loan } from '../app/user-apply-loan/loan.model';
import { Observable } from 'rxjs';
import {HttpClient, HttpEvent} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApplyloanService {

  constructor(private http: HttpClient) { }

  public applyLoan(loan:Loan):Observable<any>
  {
    return this.http.post<Loan>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/applyLoan",loan);
  }
}
