package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_table")
public class DocumentModel {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int documentId;
	private String documentType;
	private byte[] documentUpload;
	
	public DocumentModel() {
		
	} 
	public DocumentModel(int documentId, String documentType, byte[] documentUpload) {
		super();
		this.documentId = documentId;
		this.documentType = documentType;
		this.documentUpload = documentUpload;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public byte[] getDocumentUpload() {
		return documentUpload;
	}
	public void setDocumentUpload(byte[] documentUpload) {
		this.documentUpload = documentUpload;
	} 
	
	
}