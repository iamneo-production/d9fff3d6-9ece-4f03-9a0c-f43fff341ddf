import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loanmodel } from '../loanmodel';
import { UserDisplayService } from 'src/Services/user-display.service'; 

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {

  id:number;
  model:Loanmodel;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:UserDisplayService) { }

  ngOnInit(): void {
    this.model=new Loanmodel();
    this.id=this.route.snapshot.params['id'];
    this.userservice.getCustomer(this.id)
    .subscribe(data => {console.log(data)
      this.model = data;
    }, error => console.log(error)); 
  }
  list()
  {
    this.router.navigate(['/adminappliedloan']);
  }
  list1()
  {
    this.router.navigate(['/adminapprovedloan']);
  }

}
