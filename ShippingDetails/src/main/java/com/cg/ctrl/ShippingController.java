package com.cg.ctrl;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.Capg_Product;
import com.cg.entity.Cartlist;
import com.cg.entity.Customer;
import com.cg.entity.CustomerOrderBean;
import com.cg.entity.DeliveryDetailsBean;
import com.cg.entity.ShippingDetailsBean;
import com.cg.entity.WishList;
import com.cg.repo.ProductRepo;
import com.cg.service.Capg_Search_Service;
import com.cg.service.ShipService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShippingController {

	@Autowired
	private ShipService service;
	
	
	
	
	
	
	@Autowired
	private Capg_Search_Service service1;
	
	@PostMapping(value = "/product/add", consumes = "application/json")
	public String addProducts(@RequestBody Capg_Product pro) {
		if(service1.saveProducts(pro))
			return "product saved successfully.";
		else
			return "product cannot be added";
	}

	@GetMapping(value = "/product/{id}",produces = "application/json")
	public Capg_Product getProductById(@PathVariable("id") int id) {
		return service1.searchById(id);
	}
	
	@GetMapping(value = "/product/name/{na}", produces = "application/json")
	public List<Capg_Product> searchProductByName(@PathVariable("na") String na){
		return service1.getProductByName(na);
	}
	
	
	@GetMapping(value = "/product/brand/{br}", produces = "application/json")
	public List<Capg_Product> searchProductByBrand(@PathVariable("br") String br){
		return service1.getProductByBrand(br);
	}
	
	@GetMapping(value = "/product/category/{ca}", produces = "application/json")
	public List<Capg_Product> searchProductByCategory(@PathVariable("ca") String ca){
		return service1.getProductByCategory(ca);
	}
	
	@PostMapping(value = "/addtowishlist/{cust_id}", consumes = "application/json")
	public void addtoWishList(@PathVariable int cust_id,@RequestBody Capg_Product p) {
		WishList wishlist=service1.getwish(p, cust_id);
		service1.addtoWishList(wishlist);
	}
	@PostMapping(value = "/cart/add/{cust_id}", consumes = "application/json")
	public String addCart(@PathVariable("cust_id") int cust_id,@PathVariable("quantity") int quantity,@RequestBody Capg_Product p) {
		Cartlist c=service1.getcart(p,cust_id,quantity);
	 service1.addToCart(c);
			return "Product saved successfullly.";
	}

	@GetMapping(value = "/getwishlist/{custid}", produces = "application/json")
	public List<WishList> getWishItemById(@PathVariable("custid") int custid) {
		System.out.println(custid);
		return service1.getWishProducts(custid);
	}

	@DeleteMapping(value = "/deletewish/{wishId}", produces = "application/json")
	public List<WishList> deletewish(@PathVariable int wishId) {
		
		System.out.println("successfully deleted");
		return service1.deletewish(wishId);
	}

	
//	@PostMapping(value = "/add", consumes = "application/json")
//	public String addCart(@RequestBody Cartlist cart) {
//	 service1.addToCart(cart);
//			return "Product saved successfullly.";
//	}
//	
//
//	@GetMapping(value = "/cart/{custId}", produces = "application/json")
//	public List<Cartlist> getAllCarts(@PathVariable("custId")int custId) {
//		return service1.getAll(custId);
//	}


	@DeleteMapping(value = "/CartItemDelete/{cartId}", produces = "application/json")
	public void deleteCartItemtById(@PathVariable("cartId") int cartId) {
		service1.deletecart(cartId);
	}
	
	
	@GetMapping(value="/getCustomer/{cust_id}",produces="application/json")
	public Customer getCustomer(@PathVariable int cust_id)
	{
		return service1.getCustomer(cust_id);
	}
	
	@PutMapping(value = "/updateProfile/{cust_id}")
	public boolean updateCustomer(@PathVariable int cust_id,@RequestBody Customer updatedCustomer) 
	{
	Customer c=service1.getCustomer(cust_id);
	c.setCustomer_name(updatedCustomer.getCustomer_name());
		service1.updateCustomer(updatedCustomer);
		return true;
	}

	
	
	
	
	
	@GetMapping(value="/pro/{id}", produces="application/json")
	public Capg_Product getProById(@PathVariable("id") int id){
		return service.getProById(id);
	}

	@PostMapping(value = "/capstore/addtocart", consumes = "application/json")
	public int addtoCart(@RequestBody Cartlist cart) {
		return service.addtoCart(cart);
	}

	@GetMapping(value = "/capstore/get/{cartId}", produces = "application/json")
	public List<Cartlist> getAll(@PathVariable("cartId") int cartId) {
		return service.getCartList(cartId);
	}

	@GetMapping(value = "/get", produces = "application/json")
	public List<Cartlist> getAllCart() {
		return service.getAllCart();
	}
	
	@GetMapping(value = "final", produces = "application/json")
	public double finalPrice(Cartlist cart) {
		return service.getFinalprice();
	}

	@GetMapping(value = "cou/{code}", produces = "application/json")
	public double coupon(@PathVariable("code") String code, Cartlist cart) {
		return service.getFinalprice();
	}

	@PutMapping(value = "{pid}/{qty}", produces = "application/json")
	public Cartlist updateQuantity(@PathVariable("pid") int pid, @PathVariable("qty") int qty) {
		return service.update(pid, qty);
	}

	@GetMapping(value = "remove/{cartId}", produces = "application/json")
	public String remove(@PathVariable("cartId") int cartId) {
		service.remove(cartId);
		return "Successfully removed";
	}

	@GetMapping(value = "coupon/{order_id}/{couId}", produces = "application/json")
	public String applyCoupon(@PathVariable("order_id") int order_id, @PathVariable("couId") int couId) {
		service.coupon(order_id, couId);
		return "Coupon applied successfully";
	}
	
	@GetMapping(value = "/final/{cid}", produces = "application/json")
	public List<Cartlist> finalPrice(@PathVariable("cid")int cid) {
		return service1.getFinal(cid);
	}

@GetMapping(value = "/buy/{pro_id}/{qty}", produces = "application/json")
	public double buy(@PathVariable("pro_id") int pro_id, @PathVariable("qty") int qty) {
		return service1.buynow(pro_id, qty);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping(value = "/deliver", consumes = "application/json")
	public void saveDelivery(@RequestBody DeliveryDetailsBean delDelivery) {

		service.saveDelivery(delDelivery);
	}

	@PutMapping(value = "/placeOrder/{order_id}/{pro_id}", consumes = "application/json", produces = "application/json")
	public String updateProduct(@PathVariable int order_id, @PathVariable int pro_id) {
		if(service.updateProduct(order_id, pro_id))
			return "Stock is updated";
		else
			return "Stock is not updated";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/invoiceGenerated/{custId}")
	public List<CustomerOrderBean> generateInvoice(@PathVariable("custId") int custId)
	{
		return service.generateInvoice(custId);
	}
	
	@GetMapping("/getlist")
		public List<DeliveryDetailsBean> getAll(){
		return service.getAll();
	}
    
	@GetMapping("/get/{d_id}")
	public List<DeliveryDetailsBean> getById(@PathVariable("d_id") int d_id) {
		return service.getById(d_id);
	}
	@PutMapping("/return/{d_Id}")
	public List<DeliveryDetailsBean> returnGood(@PathVariable("d_Id") int d_Id)
	{
		return service.returnGood(d_Id);
		
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping(value="/shippingdetails/{custid}",consumes="application/json")
	public String setDetails(@RequestBody ShippingDetailsBean shipDetails,@PathVariable("custid")int custid ) {
		service.setDetails(shipDetails,custid);
		
		return "saved Successfully";
	}
	
	@GetMapping(value="/showdetails/{cust_id}",produces="application/json")
	public List<ShippingDetailsBean> showDetails(@PathVariable("cust_id")int cust_id){
		return service.showdetails(cust_id);
	}
}
