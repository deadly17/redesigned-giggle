import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from '../payment.model';

@Component({
  selector: 'app-credit',
  templateUrl: './credit.component.html',
  styleUrls: ['./credit.component.css']
})
export class CreditComponent implements OnInit {

  credit : Payment;
  constructor(private router:Router) {

    this.credit=new Payment();

   }

  ngOnInit() {
  }
  addcard(){
  this.router.navigate(['generate-invoice']);

  }
}
