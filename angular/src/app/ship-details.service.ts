import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CustomerOrderModel } from './customerOrder.model';
import { Cartlist } from './cart.model';
import { ProductModel } from './productAL.model';
import { wishlist } from './wishlist.model';
import { CustomerDetailsBean } from './customer.model';
import { FeedbackModel } from './feedback.model';
import { ShippingModel } from './shipping.model';

@Injectable({
  providedIn: 'root'
})
export class ShipDetailsService {
  baseUrl:string="http://localhost:9090";
  showdetail:ShippingModel[]=[];
  products:ProductModel[]=[];
 product:ProductModel;
 cart:Cartlist;
 wish:wishlist;
 custid:number;
 prodId:number;
 id:number;
  constructor(private http : HttpClient) { }

  

  shipdetails(ship:ShippingModel):Observable<any>{
    return this.http.post(`${this.baseUrl}/shippingdetails/${this.custid}`, ship);
  }

  showdetails():Observable<any>{
     return this.http.get(`${this.baseUrl}/showdetails/${this.custid}`);
  }
  invoice:CustomerOrderModel[]=[];






  getInvoice():Observable<any>{
    return this.http.get(`${this.baseUrl}/invoiceGenerated/${this.custid}`);
  }
  

  feedback(id:number):Observable<any>{
    return this.http.put(`${this.baseUrl}/feedback/${id}`,id);
  }

  storeFeedback(feedback:FeedbackModel):Observable<any>{
    return this.http.post(`${this.baseUrl}/capstore/storeFeedback`,feedback);
  }

  
  getDelivery(index:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/get/${index}`)
  }

 
  returnGood(id:number):Observable<any>{
    return this.http.put(`${this.baseUrl}/return/${id}`,id);
  }

  finalPrie(cid : number):Observable<any>{
    return this.http.get(`${this.baseUrl}/final/${this.custid}`);
  }

  buyNow(id : number, qty : number):Observable<any>{
    return this.http.get(`${this.baseUrl}/buy/${id}/${qty}`);
  }


  
  getCart1(id : number) : Observable<any> {
    return this.http.get<Cartlist[]>(`${this.baseUrl}/capstore/get/${this.prodId}`);
  }

  getProductById(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/pro/${this.prodId}`);
  }
  getAll():Observable<any> {
    return this.http.get<Cartlist[]>(`${this.baseUrl}/get`);
  }

  remove(cart:Cartlist) : Observable<any>{
    return this.http.delete(`${this.baseUrl}/remove/${cart.cartId}`);
  }





  //alekya
  searchByName(product:ProductModel){
    return this.http.get<ProductModel[]>(this.baseUrl + '/product/name/'+product.searchitem);
  }
  searchByCategory(product:ProductModel){
    return this.http.get<ProductModel[]>(this.baseUrl + '/product/category/'+product.searchitem);
  }
  searchByBrand(product:ProductModel){
    return this.http.get<ProductModel[]>(this.baseUrl + '/product/brand/'+product.searchitem);
  }
  saveproducts(prod:ProductModel){
    this.products.push(prod);
  }
  getProduct(){
    return this.http.get<ProductModel>(this.baseUrl + '/product/' + this.prodId);
  }
  getProducts(){
    return this.products;
  }

  addtoCart(product:ProductModel,quantity:number)
  {
    return this.http.post(this.baseUrl+'/cart/add/'+201+'/'+quantity,product);
  }





  getCart() {
    return this.http.get<Cartlist[]>(this.baseUrl + '/cart/'+201);
  }

  deletecart(cart:Cartlist){
    return this.http.delete(this.baseUrl + '/CartItemDelete/'+cart.cartId);
  }

  addtowish(product:ProductModel){
    return this.http.post(this.baseUrl+'/addtowishlist/'+501,product);
  }

  getWish(id:number) {
    return this.http.get<wishlist[]>(this.baseUrl + '/getwishlist/'+501);
  }

  deletewish(wish:wishlist){
    return this.http.delete(this.baseUrl + '/deletewish/'+wish.wishId);
  }
  getCustomerData(id:number){
    return this.http.get<CustomerDetailsBean>(this.baseUrl+'/getCustomer/'+1);

  }

  updateCustomer(id:number,customer:CustomerDetailsBean) 
{
 
    return this.http.put<CustomerDetailsBean>(this.baseUrl + '/updateProfile/'+1,customer);
  }


}
