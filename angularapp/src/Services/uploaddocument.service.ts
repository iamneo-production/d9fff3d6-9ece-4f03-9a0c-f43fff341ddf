import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploaddocumentService {

  constructor(private http: HttpClient) { }

  public uploadDocument(file: File, type: string): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    formData.append('documentType', type);

    return this.http.post<any>("https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io/uploadDocument", formData);
  }

  public getUploadedDocument(fileName: string) {
    return this.http.get('https://8080-ddcadebbdcbcecbaaeddadfaadaeaacdfed.examlyiopb.examly.io//getDocument/' + fileName);
  }
}
