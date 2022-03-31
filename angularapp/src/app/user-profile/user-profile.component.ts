import { Component, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CustomerProfile } from './customerProfile';
import { LoginComponent } from '../login/login.component';
import { Loanmodel } from '../loanmodel';
import { CustomerService } from 'src/Services/customer.service';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  //id:string;
  i:Loanmodel;
 user:CustomerProfile;
  constructor(private route: ActivatedRoute,private router: Router,private customerservice:CustomerService) {

   }
  id=LoginComponent.id;
  editCustomer(id : number)
  {
    this.router.navigate(['/edit', id]);
  }
 
  ngOnInit() {
  /* 
    this.id=this.route.snapshot.params['id'];*/
   // this.user=new CustomerProfile();
   this.i=new Loanmodel();
   this.customerservice.getProfile(this.id)
   .subscribe(data => {console.log(data)
      this.i = data;
    }, error => console.log(error)); 
  }
  

}
