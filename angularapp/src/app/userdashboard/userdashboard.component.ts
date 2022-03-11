import { Component, OnInit } from '@angular/core';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  // logoutUser(){
  //   this._service.logout()
  //   location.reload()
  // }

}
