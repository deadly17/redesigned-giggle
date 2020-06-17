import { Component, OnInit } from '@angular/core';

import { ShipDetailsService } from '../ship-details.service';
import { Router } from '@angular/router';
import { ShippingModel } from '../shipping.model';

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {

  shipdetails:any[]=[];
  ship:any;
  hide:boolean;
  constructor(private service:ShipDetailsService,private router:Router) {
    this.ship=new ShippingModel();
   }

  ngOnInit() {
  }

  showdetails(){
   this.service.showdetails().subscribe(data => {this.shipdetails=data}, error => console.log(error));
   this.hide=true;
  }
  proceed(){
    this.router.navigate(['payment']);
  }
  newAddress(){
    this.router.navigate(['shipdetails']);
  }

}
