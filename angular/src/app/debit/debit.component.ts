import { Component, OnInit } from '@angular/core';
import { Payment } from '../payment.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-debit',
  templateUrl: './debit.component.html',
  styleUrls: ['./debit.component.css']
})
export class DebitComponent implements OnInit {

  debit : Payment;
  
  constructor(private router:Router) {
    this.debit = new Payment();
   }

  ngOnInit() {
  }
  addcard()
  {
    
    alert("Payment Successful!!!! \nOrder is Successfully Placed");
    this.router.navigate(['generate-invoice']);
    
  }

}
