import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/Services/customer.service';
import { Loanmodel } from '../loanmodel';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {

  id:number;
  model:Loanmodel;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:CustomerService) { }
  searchCustomer(id:number)
  {
      this.router.navigate(['/userdetailsearch', id]);
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
