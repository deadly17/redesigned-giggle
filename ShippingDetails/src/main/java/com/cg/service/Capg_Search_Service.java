package com.cg.service;

import java.util.List;

import com.cg.entity.Capg_Product;
import com.cg.entity.Cartlist;
import com.cg.entity.Customer;
import com.cg.entity.WishList;



public interface Capg_Search_Service {
	
	public boolean saveProducts(Capg_Product se);
	public Capg_Product searchById(int id);
	List<Capg_Product> getProductByName(String name);
	List<Capg_Product> getProductByBrand(String brand);
	List<Capg_Product> getProductByCategory(String category);
	
	void addtoWishList(WishList wishlist);
	List<WishList> getWishProducts(int cust_Id);
	List<WishList> deletewish(int wishId);
	
	boolean addToCart(Cartlist cart);
	List<Cartlist> getAll(int cust_id);
	boolean deletecart(int prod_id);
	
	public Customer getCustomer(int cust_id);
	public Customer updateCustomer(Customer c);
	
	public Cartlist getcart(Capg_Product p,int cust_id,int quantity);
	public WishList getwish(Capg_Product p, int cust_id);
	
	public double buynow(int pro_id, int qty);
	public List<Cartlist> getAllCart(int cust_id);
	public List<Cartlist> getFinal(int custID);
}
