package com.examly.springapp.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

//import org.hibernate.annotations.GenericGenerator;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer documentId;
	
//	@Column(length=512,nullable=false,unique=true)
	private String documentName; 
	
	private String documentType;
	
	@Lob
	private byte[] data;//content
	
	public Document() {
		
	} 
	public Document(String documentName,String documentType, byte[] data) {
		super();
		this.documentName = documentName;
		this.documentType= documentType;
		this.data = data;
	}
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}