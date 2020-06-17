import { Component, OnInit } from '@angular/core';
import { ShipDetailsService } from '../ship-details.service';
import { Router } from '@angular/router';
import { ProductModel } from '../productAL.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  products:ProductModel[];
 temp:ProductModel;
 high:boolean;
 low:boolean;
 new:boolean;
 ok:boolean;
  constructor(private service:ShipDetailsService, private router:Router) { }

  ngOnInit() {

  this.products=this.service.getProducts();
   this.ok=true;
  }
  View(product:ProductModel){
    this.service.prodId=product.id;
    this.router.navigate(['view']);
  }
  sorthightolow(){
   this.high=false;
    for(let i=0; i<this.products.length;i++)
    {
      for(let j=i+1;j<this.products.length;j++)
      {
        if(this.products[i].price<this.products[j].price)
        {
          this.temp=this.products[i];
          this.products[i]=this.products[j];
          this.products[j]=this.temp;;
        }
    }
  } 
  return this.products;

  }
  sortlowtohigh(){
    this.low=false;
    for(let i=0; i<this.products.length;i++)
    {
      for(let j=i+1;j<this.products.length;j++)
      {
        if(this.products[i].price>this.products[j].price)
        {
          this.temp=this.products[i];
          this.products[i]=this.products[j];
          this.products[j]=this.temp;;
        }
    }
  }
  return this.products;

  }
  sortbynewarrivals(){
    this.new=false;
    for(let i=0; i<this.products.length;i++)
    {
      for(let j=i+1;j<this.products.length;j++)
      {
        if(this.products[i].id<this.products[j].id)
        {
          this.temp=this.products[i];
          this.products[i]=this.products[j];
          this.products[j]=this.temp;;
        }
    }
  }
  return this.products;
  }

}
