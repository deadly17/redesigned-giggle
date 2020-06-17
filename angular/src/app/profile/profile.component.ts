import { Component, OnInit } from '@angular/core';
import { CustomerOrderModel } from '../customerOrder.model';
import { ShipDetailsService } from '../ship-details.service';
import { CustomerDetailsBean } from '../customer.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  edit:any;
  id:number;
    constructor(private service:ShipDetailsService) { 
      this.edit=new CustomerDetailsBean();
      id:this.edit.customer_id;
      id:Number;
    }
  
    ngOnInit() {
     this.service.getCustomerData(this.id).subscribe(data=>this.edit=data);
     this.edit=new CustomerDetailsBean();
    }
  
    update(edit:CustomerDetailsBean){
      var ans=confirm("are sure u to edit it")
      if(ans)
      {
       
  this.service.updateCustomer(edit.customer_id,edit).subscribe(data=>{this.edit=data})
  this.edit=new CustomerDetailsBean();
    
    }
  }

}
