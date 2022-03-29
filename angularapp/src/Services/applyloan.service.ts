import { Injectable } from '@angular/core';
import { Loanmodel} from '../app/loanmodel';
import { Observable } from 'rxjs';
import {HttpClient, HttpEvent} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApplyloanService {

  constructor(private http: HttpClient) { }

  public applyLoan(loan:Loanmodel):Observable<any>
  {
    return this.http.post<Loanmodel>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/applyLoan",loan);
  }
}
