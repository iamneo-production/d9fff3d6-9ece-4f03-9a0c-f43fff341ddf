import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import {ApplyloanService } from '../../Services/applyloan.service';

describe('LoanService', () => {
  
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], 
      providers: [ApplyloanService]
    });
    // service = TestBed.inject(LoanService);
  });

  it('should be created', () => {
    const service: ApplyloanService = TestBed.get(ApplyloanService);
    expect(service).toBeTruthy();
  });

  it('should have applyLoan function', () => {
    const service: ApplyloanService = TestBed.get(ApplyloanService);
    expect(service.applyLoan).toBeTruthy();
   });

});
