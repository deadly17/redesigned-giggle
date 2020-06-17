import { Component, OnInit } from '@angular/core';
import { ShipDetailsService } from '../ship-details.service';
import { CustomerOrderModel } from '../customerOrder.model';
import { DeliveryModel } from '../delivery.model';
import { HttpClient } from '@angular/common/http';
import { CustomerOrderBean } from '../order.model';
import { FeedbackModel } from '../feedback.model';
import { Cartlist } from '../cart.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-generate-invoice',
  templateUrl: './generate-invoice.component.html',
  styleUrls: ['./generate-invoice.component.css']
})
export class GenerateInvoiceComponent implements OnInit {

  invoices:any[]=[];
  in:CustomerOrderModel;
  order:any;
  invoice:Cartlist;

// Feedback
ratingFeedback:FeedbackModel;
  rating:number[]=[];
  feedbacks:any[]=[];
  prodId:number;
  flag:boolean=false;
  
  constructor(private service:ShipDetailsService,private http:HttpClient,private route:Router) { 
  // this.invoices=new CustomerOrderModel();
    this.in=new CustomerOrderModel();
    this.invoice=new Cartlist();

    //Feedback

    this.ratingFeedback = new FeedbackModel();
    this.feedbacks[0]=new FeedbackModel();
    this.ratingFeedback.prodId = 707;
    this.rating = [1,2,3,4,5];
  }

  ngOnInit() {
   this.service.getInvoice().subscribe(data=> {this.invoices=data},error=>console.log(error));
   
  }

  
    feedback(index:number){
         this.service.feedback(index).subscribe(data=>{this.in=data},error=>console.log(error));
       }

       submitFeedback(){
        this.service.storeFeedback(this.ratingFeedback).subscribe(data=>{console.log(data)},error=>{console.log(error)});
        this.route.navigate(['ordered-items']);
      }
    
  }

