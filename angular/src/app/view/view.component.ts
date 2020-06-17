import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
import { ShipDetailsService } from '../ship-details.service';
import { Cartlist } from '../cart.model';
import { ProductModel } from '../productAL.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  quantity:number;
  product:any;
  constructor(private service:ShipDetailsService,private router:Router) {
    this.product= new ProductModel();
   }

  ngOnInit() {
   
    this.service.getProduct().subscribe(data=>{this.product= data,console.log(this.product)});
    this.product= new ProductModel();
  }

  addCart(){
   if(this.quantity<=this.product.stock){
    this.service.addtoCart(this.product,this.quantity).subscribe();
    var ans=alert("added to cart");
   }
    else
      alert("The quantity you required is out of stock!!");

  
  
}

wishlist()
  {
    this.service.addtowish(this.product).subscribe(data=>{});
    var ans=alert("added to wishlist");
  }

  
  buynow(){
    this.product.total= this.service.buyNow(this.product.id,2)
    .subscribe(data => {
    });
		
    this.router.navigate(['showdetails']);
  }

}
