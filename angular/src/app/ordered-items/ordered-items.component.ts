import { Component, OnInit } from '@angular/core';
import { ShipDetailsService } from '../ship-details.service';
import { HttpClient } from '@angular/common/http';
import { CustomerOrderModel } from '../customerOrder.model';
import { DeliveryModel } from '../delivery.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ordered-items',
  templateUrl: './ordered-items.component.html',
  styleUrls: ['./ordered-items.component.css']
})
export class OrderedItemsComponent implements OnInit {

  // order:any[]=[];
  // o:any;
  d:any;
  delivery:any[]=[];
  index:number;

  constructor(private service:ShipDetailsService,private http:HttpClient,private route:Router) { 
    // this.o=new CustomerOrderModel();
    this.d=new DeliveryModel();
  }

  ngOnInit() {
    // this.service.getInvoice()
    // .subscribe(data=> {this.order=data},error=>console.log(error));
    //this.http.put<CustomerOrderModel[]>(`http://localhost:9000/return/${this.order.order_id}`).subscribe(data => {this.invoice=data,console.log(this.invoice)},error => console.log(error));
   this.service.getDelivery(201)
   .subscribe(data=> {this.delivery=data},error=>console.log(error));
  }

  returnGood(ino:number)
  {
    var ab=confirm("are you sure you want to return your good?");
    if(ab)
    {
     this.service.returnGood(ino)
     .subscribe(data=>{this.delivery=data},error=>console.log(error));
     this.service.getDelivery(201)
   .subscribe(data=> {this.delivery=data},error=>console.log(error));
     this.route.navigate(['ordered-items']);
    }
    
  }
}
