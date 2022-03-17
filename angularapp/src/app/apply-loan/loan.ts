

export class Loan{
    loanId!:number;
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
    documentId!:number;
    documentType!:string;
    documentUpload!:File;
  }