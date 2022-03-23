package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoanModel {
		@Id
		private int loanId;
		private String loantype;
		private String applicantName;
		private String applicantAddress;
		private String applicantMobile;
		private String applicantEmail;
		private String applicantAadhar;
		private String applicantPan;
		private String applicantSalary;
		private String loanAmountRequired;
		private	String repaymentMonths;
		@Column(length=3000)
		private String apprej;
		public LoanModel() {
			super();
	
		}
		public LoanModel(int loanId, String loantype, String applicantName, String applicantAddress,
				String applicantMobile, String applicantEmail, String applicantAadhar, String applicantPan,
				String applicantSalary, String loanAmountRequired, String repaymentMonths,String apprej) {
			super();
			this.loanId = loanId;
			this.loantype = loantype;
			this.applicantName = applicantName;
			this.applicantAddress = applicantAddress;
			this.applicantMobile = applicantMobile;
			this.applicantEmail = applicantEmail;
			this.applicantAadhar = applicantAadhar;
			this.applicantPan = applicantPan;
			this.applicantSalary = applicantSalary;
			this.loanAmountRequired = loanAmountRequired;
			this.repaymentMonths = repaymentMonths;
			this.apprej=apprej;
		}
		public int getLoanId() {
			return loanId;
		}
		public void setLoanId(int loanId) {
			this.loanId = loanId;
		}
		public String getLoantype() {
			return loantype;
		}
		public void setLoantype(String loantype) {
			this.loantype = loantype;
		}
		public String getApplicantName() {
			return applicantName;
		}
		public void setApplicantName(String applicantName) {
			this.applicantName = applicantName;
		}
		public String getApplicantAddress() {
			return applicantAddress;
		}
		public void setApplicantAddress(String applicantAddress) {
			this.applicantAddress = applicantAddress;
		}
		public String getApplicantMobile() {
			return applicantMobile;
		}
		public void setApplicantMobile(String applicantMobile) {
			this.applicantMobile = applicantMobile;
		}
		public String getApplicantEmail() {
			return applicantEmail;
		}
		public void setApplicantEmail(String applicantEmail) {
			this.applicantEmail = applicantEmail;
		}
		public String getApplicantAadharr() {
			return applicantAadhar;
		}
		public void setApplicantAadharr(String applicantAadhar) {
			this.applicantAadhar = applicantAadhar;
		}
		public String getApplicantPan() {
			return applicantPan;
		}
		public void setApplicantPan(String applicantPan) {
			this.applicantPan = applicantPan;
		}
		public String getApplicantSalary() {
			return applicantSalary;
		}
		public void setApplicantSalary(String applicantSalary) {
			this.applicantSalary = applicantSalary;
		}
		public String getLoanAmountRequired() {
			return loanAmountRequired;
		}
		public void setLoanAmountRequired(String loanAmountRequired) {
			this.loanAmountRequired = loanAmountRequired;
		}
		public String getRepaymentMonths() {
			return repaymentMonths;
		}
		public void setRepaymentMonths(String repaymentMonths) {
			this.repaymentMonths = repaymentMonths;
		}
		public String getApprej() {
			return apprej;
		}
		public void setApprej(String apprej) {
			this.apprej = apprej;
		}
		public boolean isPresent() {
			return false;
		}
		
}
