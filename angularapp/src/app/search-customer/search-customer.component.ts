import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDisplayService } from 'src/Services/user-display.service';
import { Loanmodel } from '../loanmodel';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.css']
})
export class SearchCustomerComponent implements OnInit {
  id:number;
  model:Loanmodel;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:UserDisplayService) { }
  searchCustomer(id:number)
  {
      this.router.navigate(['/searchdetail', id]);
  }
  ngOnInit(): void {
    this.model=new Loanmodel();
    this.id=this.route.snapshot.params['id'];
    this.userservice.getCustomer(this.id)
    .subscribe(data => {console.log(data)
      this.model = data;
    }, error => console.log(error)); 
  }
  

}
