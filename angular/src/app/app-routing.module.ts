import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule,Routes} from '@angular/router';
import { ShipdetailsComponent } from './shipdetails/shipdetails.component';
import { ShowDetailsComponent } from './show-details/show-details.component';
import { GenerateInvoiceComponent } from './generate-invoice/generate-invoice.component';
import { OrderedItemsComponent } from './ordered-items/ordered-items.component';
import { CodComponent } from './cod/cod.component';
import { CreditComponent } from './credit/credit.component';
import { DebitComponent } from './debit/debit.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { HomeComponent } from './home/home.component';
import { SettingsComponent } from './settings/settings.component';
import { ProfileComponent } from './profile/profile.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { UserComponent } from './user/user.component';
import { SearchComponent } from './search/search.component';
import { ViewComponent } from './view/view.component';
import { PaymentComponent } from './payment/payment.component';

const routes :Routes=[
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'shipdetails',component:ShipdetailsComponent},
  {path:'showdetails',component:ShowDetailsComponent},
  {path:'generate-invoice',component:GenerateInvoiceComponent},
  {path:'ordered-items',component:OrderedItemsComponent},
  {path:'getlist', component:ShoppingCartComponent},
  {path:'cod', component:CodComponent},
  {path:'credit', component:CreditComponent},
  {path:'debit', component:DebitComponent},
  {path:'payment', component:PaymentComponent},
  {path:'home',component:HomeComponent},
  {path: 'settings', component:SettingsComponent},
  {path:'proile',component:ProfileComponent},
  {path:'wishlist',component:WishlistComponent},
  {path:'user',component:UserComponent},
  {path:'search',component:SearchComponent},
  {path:'view',component:ViewComponent},
  {path:'**',redirectTo:'/home',pathMatch:'full'}
]

@NgModule({
  imports: [
    CommonModule,RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports:[RouterModule]
})
export class AppRoutingModule { }
