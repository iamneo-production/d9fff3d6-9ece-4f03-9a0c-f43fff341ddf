export class Loan{
    applicantName!:string;
    applicantAddress!:string;
    applicantMobile!:string;
    applicantEmail!:string;
    applicantAadhar!:string;
    applicantPan!:string;
    applicantSalary!:string;
    loanAmountRequired!:string;
    loanRepaymentMonths!:string; 
  }

  export class Document{
    documentType!:string;
    documentUpload!:File;
  }