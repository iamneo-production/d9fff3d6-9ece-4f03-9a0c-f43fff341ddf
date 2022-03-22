import { Component, OnInit } from '@angular/core';
import { FileUploadResponse } from './file-upload-response';

import { DocumentService } from './upload-document.service';


@Component({
  selector: 'app-upload-document',
  templateUrl: './upload-document.component.html',
  styleUrls: ['./upload-document.component.css']
})
export class UploadDocumentComponent implements OnInit {
  message: string | undefined;
  selectedFile: any = File;
  documentId:any;
  documentType:string;
  fileRes : any;
  viewUrl : any;

  constructor(private documentService: DocumentService) {
     this.fileRes = new FileUploadResponse;
  }

  public onFileChanged(event) {
    const file = event.target.files[0];
    this.selectedFile = file;
    
  }

  public onUpload() {
    console.log(this.selectedFile);
    this.documentService.uploadDocument(this.selectedFile,this.documentType).subscribe(
      response => {
        console.log(response);
        this.fileRes = response;
        this.viewUrl = this.fileRes.url;
        this.message = `File uploaded successfully`;
      },
      // data => {
      //   this.message = `File uploaded successfully your document id is ${data}`;
      // },
      error => {
        this.message = 'Error! while uploading file';
      }
    );
  }

  public getFile() {

    this.documentService.getUploadedDocument(this.fileRes.fileName).subscribe(
      res => {
       console.log(res);
      },
      err => {
        this.message = 'Error! while getting file';
      }
    );
  }


  ngOnInit(): void {
    
  }

}
