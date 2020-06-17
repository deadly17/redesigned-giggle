import { Component, OnInit } from '@angular/core';
import { wishlist } from '../wishlist.model';
import { ShipDetailsService } from '../ship-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  wishes:wishlist[];
  wish:wishlist;
  id:number;
    constructor( private Service: ShipDetailsService,private router:Router) { }
  
    ngOnInit() {
      this.Service.getWish(this.id).subscribe( data => {
          this.wishes = data;
        });
    }
    remove(wish:wishlist){
      this.Service.deletewish(wish).subscribe( data => {
    });
}

}
