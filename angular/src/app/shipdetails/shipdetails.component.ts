import { Component, OnInit } from '@angular/core';

import { ShipDetailsService } from '../ship-details.service';
import { Router } from '@angular/router';
import { ShippingModel } from '../shipping.model';

@Component({
  selector: 'app-shipdetails',
  templateUrl: './shipdetails.component.html',
  styleUrls: ['./shipdetails.component.css']
})
export class ShipdetailsComponent implements OnInit {

  ship:ShippingModel;
  constructor(private service: ShipDetailsService,private routes : Router) {
    this.ship=new ShippingModel();
   }

  ngOnInit() {
  }

  

  showdetails(){
    this.service.shipdetails(this.ship).subscribe(data => {this.ship=data,console.log(this.ship)}, error => console.log(error));
    this.ship = new ShippingModel();
    var ans=confirm("The Product will be delivered to mentioned Address!!");
    if(ans)
     this.routes.navigate(['payment']);
     else
      this.routes.navigate(['showdetails']);
  }
}
