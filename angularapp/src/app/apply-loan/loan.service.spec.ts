import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { LoanService } from './loan.service';

describe('LoanService', () => {
  
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], 
      providers: [LoanService]
    });
    // service = TestBed.inject(LoanService);
  });

  it('should be created', () => {
    const service: LoanService = TestBed.get(LoanService);
    expect(service).toBeTruthy();
  });

  it('should have applyLoan function', () => {
    const service: LoanService = TestBed.get(LoanService);
    expect(service.applyLoan).toBeTruthy();
   });

  it('should have uploadDocument function', () => {
    const service: LoanService = TestBed.get(LoanService);
    expect(service.uploadDocument).toBeTruthy();
   });
});
