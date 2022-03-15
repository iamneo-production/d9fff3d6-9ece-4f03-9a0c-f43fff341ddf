import { Component, OnInit } from '@angular/core';
import { FormBuilder,Validators } from '@angular/forms';
import { Loan,Document } from './loan';
import { LoanService } from './loan.service';
import { Router } from '@angular/router';
import { HttpClient, HttpEventType } from '@angular/common/http';
@Component({
  selector: 'app-apply-loan',
  templateUrl: './apply-loan.component.html',
  styleUrls: ['./apply-loan.component.css'],
  exportAs:'Form'
})
export class ApplyLoanComponent implements OnInit{
  loan: Loan;
  doc: Document;
  message: string|undefined;

  constructor(
    private formbuilder: FormBuilder,
    private loanService: LoanService  
    ) { 
    this.loan = new Loan();
    this.doc = new Document();
  }

  onApplyLoan(){
    console.log(this.loan);

    this.loanService.applyLoan(this.loan).subscribe(response => {
      if (response.status === 200) {
        this.message = 'Loan Applied successfully';
      } else {
        this.message = 'Error! Please Try Again';
      }
    });
  }

  public onFileChanged(event) {
    this.uploadDocument = event.target.files[0];
    // this.selectedFile = event.target.files[0];
  }

  public onUpload(){
    console.log(this.documentUpload);
    // const uploadFileData = new FormData();
    // uploadFileData.append('file', this.selectedFile);

    this.loanService.uploadDocument(this.doc).subscribe(response => {
      if (response.status === 200) {
        this.message = 'File uploaded successfully';
      } else {
        this.message = 'File not uploaded successfully';
      }
    });
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
    documentType: ['', [Validators.required]],
    documentUpload: ['', [Validators.required]]
  })



  get applicantName() {
    return this.Form.get('applicantName');
  }
  get namecontrols() {
    return this.Form.controls['applicantName'].errors;
  }
  get applicantAddress() {
    return this.Form.get('applicantAddress');
  }
  get addresscontrols() {
    return this.Form.controls['applicantAddress'].errors;
  }
  get applicantMobile() {
    return this.Form.get('applicantMobile');
  }
  get mobilecontrols() {
    return this.Form.controls['applicantMobile'].errors;
  }
  get applicantEmail() {
    return this.Form.get('applicantEmail');
  }
  get emailcontrols() {
    return this.Form.controls['applicantEmail'].errors;
  }
  get applicantAadhar() {
    return this.Form.get('applicantAadhar');
  }
  get aadharcontrols() {
    return this.Form.controls['applicantAadhar'].errors;
  }
  get applicantPan() {
    return this.Form.get('applicantPan');
  }
  get pancontrols() {
    return this.Form.controls['applicantPan'].errors;
  }
  get applicantSalary() {
    return this.Form.get('applicantSalary');
  }
  get salarycontrols() {
    return this.Form.controls['applicantSalary'].errors;
  }
  get loanAmountRequired() {
    return this.Form.get('loanAmountRequired');
  }
  get amountcontrols() {
    return this.Form.controls['loanAmountRequired'].errors;
  }
  get loanRepaymentMonths() {
    return this.Form.get('loanRepaymentMonths');
  }
  get repaycontrols() {
    return this.Form.controls['loanRepaymentMonths'].errors;
  }
  get documentType() {
    return this.Form.get('documentType');
  }
  get typecontrols() {
    return this.Form.controls['documentType'].errors;
  }
  get documentUpload() {
    return this.Form.get('documentUpload');
  }
  set uploadDocument(selectedFile: File) {
    this.Form.get('documentUpload')?.setValue(selectedFile);
  }
  get doccontrols() {
    return this.Form.controls['documentUpload'].errors;
  }

  

  ngOnInit(): void {
  }
}
