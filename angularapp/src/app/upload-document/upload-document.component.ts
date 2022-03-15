import { Component, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';
// import { Document } from '../document';
import { Router } from '@angular/router';

@Component({
  selector: 'app-upload-document',
  templateUrl: './upload-document.component.html',
  styleUrls: ['./upload-document.component.css']
})
export class UploadDocumentComponent implements OnInit {

  public userFile:any=File;

  // document=new Document();
  msg=""

  constructor(private _service: SignupService ,private _router: Router) { }

  ngOnInit(): void {
  }

  onSelectFile(event:any){
    const file=event.target.files[0];
    this.userFile=file;
    console.log(file);
  }
  
  uploadDocument(){
    this._service.uploadDocumentFromRemote(this.userFile).subscribe(
      data =>{
        console.log("Document Uploaded Sucessfully");
        this.msg=("Document Updation Successful");
        this._router.navigate(['/login']);
       },
      error => {
        console.log("Exception has Occured")
        this.msg="Upload Document Failed";
      }
    )
  }
  

}
