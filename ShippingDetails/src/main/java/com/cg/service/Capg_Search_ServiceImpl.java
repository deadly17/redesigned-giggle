package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Capg_Product;
import com.cg.entity.Cartlist;
import com.cg.entity.Customer;
import com.cg.entity.CustomerOrderBean;
import com.cg.entity.WishList;
import com.cg.repo.Capg_Search_Repo;
import com.cg.repo.CartlistRepo;
import com.cg.repo.CustomerRepo;
import com.cg.repo.ProductRepo;
import com.cg.repo.WishListRepo;

@Service
@Transactional
public class Capg_Search_ServiceImpl implements Capg_Search_Service {

	@Autowired
	private Capg_Search_Repo repo;
	
	@Autowired 
	WishListRepo wishRepo;
	
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired 
	CartlistRepo cartRepo;
	
	@Autowired
	CustomerRepo dao;
	
	double finalprice;
	public double getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}

	@Override
	public boolean saveProducts(Capg_Product se) {
		if (repo.save(se) != null)
			return true;
		else
			return false;
	}

	@Override
	public Capg_Product searchById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Capg_Product> getProductByName(String name) {
		return repo.getProductByName(name);
	}

	@Override
	public List<Capg_Product> getProductByBrand(String brand) {
		return repo.getProductByBrand(brand);
	}

	@Override
	public List<Capg_Product> getProductByCategory(String category) {
		return repo.getProductByCategory(category);
	}
	
	public void addtoWishList(WishList wishlist) {
		wishRepo.save(wishlist);
		
	}
	public List<WishList> getWishProducts(int cust_id) {
		// TODO Auto-generated method stub
		return wishRepo.getWishListById(cust_id);
	}
	public List<WishList> deletewish(int wishId) {
		wishRepo.deleteById(wishId);
		return wishRepo.findAll();
		
	}
	
	
	@Override
	public boolean addToCart(Cartlist cl) {

		double ans = this.calculation(cl.getPro_id().getId(), cl);
		cl.settPrice(ans);
		// System.out.println(ans);
//		double finalprice = cl.getFinalprice() + ans;
//		cl.setFinalprice(finalprice);
		cartRepo.save(cl);
		return true;
	}
	@Override
	public List<Cartlist> getAll(int cust_id) {
		// TODO Auto-generated method stub
		return cartRepo.getCartListById1(cust_id);
	}

	@Override
	public boolean deletecart(int cart_id) {
		// TODO Auto-generated method stub
		 cartRepo.deleteById(cart_id);
		 return true;
	} 

	
	@Override
	public Customer getCustomer(int cust_id) {
		// TODO Auto-generated method stub
		return dao.findById(cust_id).get();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		 return  dao.save(c);
	} 
	

	@Override
	public Cartlist getcart(Capg_Product p,int cust_id,int quantity) {
		// TODO Auto-generated method stub
		Cartlist cart=new Cartlist(cust_id,p,2,quantity);
		return cart;
	}

	@Override
	public WishList getwish(Capg_Product p, int cust_id) {
		// TODO Auto-generated method stub
		WishList wish=new WishList(p,cust_id);
		return wish;
	}
	
	public double calculation(int id, Cartlist cart) {
		Capg_Product pro = prodRepo.findById(id).get();
		double price1 = pro.getPrice() * cart.getQuantity();
//		System.out.println(price1);
		double totalPrice = price1 - ((price1 * pro.getDiscount() * 1.0) / 100);
		cart.settPrice(totalPrice);
//		System.out.println(totalPrice);
		return totalPrice;
	}
	@Override
	public double buynow(int pro_id, int qty) {
		Capg_Product pro = prodRepo.findById(pro_id).get();
		double price = pro.getPrice() * qty;

		double totalPrice = price - ((price * pro.getDiscount() * 1.0) / 100);
		System.out.println(totalPrice);
		
		CustomerOrderBean order = new CustomerOrderBean();
		order.setPrice(totalPrice);
		
		return totalPrice;
		
	
	}
	@Override
	public List<Cartlist> getFinal(int custID) {
		double price=0;
		CustomerOrderBean order = new CustomerOrderBean();
				
		List<Cartlist> cartlist = cartRepo.getCartListById1(custID);
		for(int i=0;i<cartlist.size();i++) {
			price = price+cartlist.get(i).gettPrice();
			cartlist.get(i).setFinalprice(price);
//			System.out.println(price);
			order.setPrice(price);
		}
		return cartlist;
		
	}

	@Override
	public List<Cartlist> getAllCart(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
