import { Component, OnInit } from '@angular/core';
import { Cartlist } from '../cart.model';
import { Product } from '../product.model';
import { ShipDetailsService } from '../ship-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {
  carts:Cartlist[]=[];
  cart:any;
  id:number;
  tot:number;
    constructor( private cartService: ShipDetailsService) {
      this.cart = new Cartlist();
     }
  
    ngOnInit() {
      this.cartService.getCart().subscribe( data => {
          this.carts = data,console.log(data)
        });

        // this.cart.finalPrice =  this.cartService.finalPrie(this.cart).subscribe(data=>{
        //   this.cart = data ,errors => console.log(errors)    });
        this.finalPrice();
        
    }
    finalPrice(){
     this.cartService.finalPrie(this.id).subscribe(data=>{
            this.carts = data});
    }
    join(){
this.tot=this.carts.length-1;
    }
    remove(cart:Cartlist){
      this.cartService.deletecart(cart).subscribe(data => {
         });
        }

}
