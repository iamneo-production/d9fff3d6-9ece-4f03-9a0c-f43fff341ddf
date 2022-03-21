import { Component, OnInit } from '@angular/core';

import { DocumentService } from './upload-document.service';


@Component({
  selector: 'app-upload-document',
  templateUrl: './upload-document.component.html',
  styleUrls: ['./upload-document.component.css']
})
export class UploadDocumentComponent implements OnInit {
  message: string | undefined;
  selectedFile: any = File;
  retrievedFile: any;
  base64Data: any;
  retrieveResonse: any;
  documentId:any;
  


  constructor(private documentService: DocumentService) {}

  public onFileChanged(event) {
    const file = event.target.files[0];
    this.selectedFile = file;
    console.log(file);
  }

  public onUpload() {

    this.documentService.uploadDocument(this.selectedFile).subscribe(
      data => {
        this.message = `File uploaded successfully your document id is ${data}`;
      },
      error => {
        this.message = 'Error! while uploading file';
      }
    );
  }

  public getFile() {

    this.documentService.getUploadedDocument(this.documentId).subscribe(
      res => {
        this.retrieveResonse = res;
        this.base64Data = this.retrieveResonse.uploadDocument;
        this.retrievedFile = 'data:image/jpeg;base64,' + this.base64Data;
      }
    );
  }






  ngOnInit(): void {
  }

}
