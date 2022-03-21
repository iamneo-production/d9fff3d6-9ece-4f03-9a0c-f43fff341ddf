import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(private http: HttpClient) { }

  public uploadDocument(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('files', file, file.name);

    return this.http.post<any>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/uploadDocument", formData);
  }

  public getUploadedDocument(id : number){
   return this.http.get('https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/file/get/' + id);
  }
}
