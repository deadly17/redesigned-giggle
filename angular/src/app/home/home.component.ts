import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShipDetailsService } from '../ship-details.service';
import { HomeModel } from '../home.model';
import { ProductModel } from '../productAL.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  product:any;
  home:HomeModel;
  searchby :string[];
  products:any[]=[];
  hide:boolean=true;
  constructor(private router:Router,private service:ShipDetailsService) {
    this.searchby = [ 'category', 'brand' , 'name'];
    this.home=new HomeModel();
    this.product= new ProductModel();
    this.products[0]= new ProductModel();
   }

  ngOnInit() {

  }
  
  User(){
    this.router.navigate(['user']);
   this.hide=false;
  }

  upload(){
    if(this.product.searchitemby=='category'){
      this.service.searchByCategory(this.product).subscribe(data=>{this.products=data,console.log(this.products)});
    }
    if(this.product.searchitemby=='brand'){
      this.service.searchByBrand(this.product).subscribe(data=>{this.products= data,console.log(this.products)});

    }
    if(this.product.searchitemby=='name'){
      this.service.searchByName(this.product).subscribe(data=>{this.products= data,console.log(this.products)});
    }
  }

  search(){
    if(this.product.searchitemby=='name'){
      this.service.searchByName(this.product).subscribe(data=>{this.products= data,console.log(this.products)});
    }
    if(this.product.searchitemby=='category'){
           this.service.searchByCategory(this.product).subscribe(data=>{this.products=data,console.log(this.products)});
      }
  
    if(this.product.searchitemby=='brand'){
      this.service.searchByBrand(this.product).subscribe(data=>{this.products=data,console.log(this.products)});

    }
    console.log(this.products[0]);
    for(let i=0;i<this.products.length;i++){
      this.service.saveproducts(this.products[i]);
    
    }
    this.products=[];
    this.router.navigate(['search']);
  }


}
