import { Component, OnInit, ɵExtraLocaleDataIndex } from '@angular/core';
import { Router } from '@angular/router';
import { UserDisplayService } from 'src/Services/user-display.service';
import { Loanmodel } from '../loanmodel';
import { SearchCustomerComponent } from '../search-customer/search-customer.component';

@Component({
  selector: 'app-adminapprovedloan',
  templateUrl: './adminapprovedloan.component.html',
  styleUrls: ['./adminapprovedloan.component.css']
})
export class AdminapprovedloanComponent implements OnInit {
 
  id:number;
  users: Loanmodel[];
 
  constructor(private displayservice:UserDisplayService,private router:Router) {
   
   }

  ngOnInit(): void {
    this.reloadData();
  }
  deleteCustomer(id: number) {
    this.displayservice.deleteCustomer(id).subscribe(data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  customerDetails(id: number){
    this.router.navigate(['/details', id]);
  }
  searchCustomer(id:number)
  {
      this.router.navigate(['/searchdetail', id]);
  }
  reloadData() {
    this.displayservice.getEmployeesList().subscribe(data=>{ this.users=data});
 }
 editCustomer(id : number)
  {
    this.router.navigate(['/edit', id]);
  }
 
}
