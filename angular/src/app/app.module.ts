import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ShipdetailsComponent } from './shipdetails/shipdetails.component';
import { ShowDetailsComponent } from './show-details/show-details.component';
import{FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { GenerateInvoiceComponent } from './generate-invoice/generate-invoice.component';
import { OrderedItemsComponent } from './ordered-items/ordered-items.component';
import { DebitComponent } from './debit/debit.component';
import { CreditComponent } from './credit/credit.component';
import { CodComponent } from './cod/cod.component';
import { RemoveComponent } from './remove/remove.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { ViewComponent } from './view/view.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';
import { SettingsComponent } from './settings/settings.component';
import { UserComponent } from './user/user.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    ShipdetailsComponent,
    ShowDetailsComponent,
    GenerateInvoiceComponent,
    OrderedItemsComponent,
    DebitComponent,
    CreditComponent,
    CodComponent,
    RemoveComponent,
    ShoppingCartComponent,
    ViewComponent,
    HomeComponent,
    ProfileComponent,
    SearchComponent,
    SettingsComponent,
    UserComponent,
    WishlistComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,FormsModule,AppRoutingModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
