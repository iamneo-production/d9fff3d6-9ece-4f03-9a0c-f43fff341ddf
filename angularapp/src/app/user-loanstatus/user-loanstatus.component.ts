import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDisplayService } from 'src/Services/user-display.service';
import { Loanmodel } from '../loanmodel';

@Component({
  selector: 'app-user-loanstatus',
  templateUrl: './user-loanstatus.component.html',
  styleUrls: ['./user-loanstatus.component.css']
})
export class UserLoanstatusComponent implements OnInit {

  id:number;
  constructor(private route: ActivatedRoute,private router: Router,private userservice:UserDisplayService) { }

  ngOnInit(): void {
  } 
  searchCustomer(id:number)
  {
      this.router.navigate(['/userdetailsearch', id]);
  }


}
