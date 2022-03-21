import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { Loan } from './loan';
import { LoanService } from './loan.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-apply-loan',
  templateUrl: './apply-loan.component.html',
  styleUrls: ['./apply-loan.component.css'],
  exportAs:'Form'
})
export class ApplyLoanComponent implements OnInit{
  loan: Loan;
  message: string|undefined;

  constructor(
    private formbuilder: FormBuilder,
    private loanService: LoanService  
    ) { 
    this.loan = new Loan();
    
  }

  onApplyLoan(){
    console.log(this.loan);

    this.loanService.applyLoan(this.loan).subscribe(
     data => {
        this.message = `Loan Applied successfully  Your Loan Id is ${data}`;
      },
      error => {
        this.message = 'Error! Please Try Again';
      }
    );
  }

  

  emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

  panRegex = "[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}";

  aadharRegex = "[2-9]{1}[0-9]{11}";

  repayRegex = "^[1-9]\\d{0,1}$";

  Form = this.formbuilder.group({
    applicantName: ['', [Validators.required, Validators.minLength(3)]],
    applicantAddress: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(30)]],
    applicantMobile: ['', [Validators.required, Validators.minLength(10)]],
    applicantEmail: ['', [Validators.required, Validators.pattern(this.emailRegex)]],
    applicantAadhar: ['', [Validators.required, Validators.pattern(this.aadharRegex)]],
    applicantPan: ['', [Validators.required, Validators.pattern(this.panRegex)]],
    applicantSalary: ['', [Validators.required]],
    loanAmountRequired: ['', [Validators.required]],
    loanRepaymentMonths: ['', [Validators.required, Validators.pattern(this.repayRegex)]],
    documentType: ['', [Validators.required]]
  })



  get applicantName() {
    return this.Form.get('applicantName');
  }
  
  get applicantAddress() {
    return this.Form.get('applicantAddress');
  }
 
  get applicantMobile() {
    return this.Form.get('applicantMobile');
  }
  
  get applicantEmail() {
    return this.Form.get('applicantEmail');
  }
 
  get applicantAadhar() {
    return this.Form.get('applicantAadhar');
  }
 
  get applicantPan() {
    return this.Form.get('applicantPan');
  }
  
  get applicantSalary() {
    return this.Form.get('applicantSalary');
  }
 
  get loanAmountRequired() {
    return this.Form.get('loanAmountRequired');
  }
  
  get loanRepaymentMonths() {
    return this.Form.get('loanRepaymentMonths');
  }

  get documentType() {
    return this.Form.get('documentType');
  }

  ngOnInit(): void {
  }
}
