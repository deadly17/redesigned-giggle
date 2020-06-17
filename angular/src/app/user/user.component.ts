import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  wishlist(){
this.router.navigate(['wishlist']);
  }
  cart(){
    console.log("in cart fun");
    this.router.navigate(['getlist']);
  }
  profile(){
    this.router.navigate(['proile']);
  }
  order(){
    this.router.navigate(['ordered-items']);
  }


}
