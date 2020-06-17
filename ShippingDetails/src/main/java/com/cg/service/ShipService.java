package com.cg.service;

import java.util.List;

import com.cg.entity.Capg_Product;
import com.cg.entity.Cartlist;
import com.cg.entity.CustomerOrderBean;
import com.cg.entity.DeliveryDetailsBean;
import com.cg.entity.ShippingDetailsBean;

public interface ShipService {

	public void setDetails(ShippingDetailsBean shipDetails,int cust_id);

	public List<ShippingDetailsBean> showdetails(int cust_id);
	
	
	

	public List<DeliveryDetailsBean> returnGood(int d_Id);

	public List<DeliveryDetailsBean> getById(int d_id);

	public List<DeliveryDetailsBean> getAll();

	public  List<CustomerOrderBean> generateInvoice(int orderId);
	
	
	
	
	

	public boolean updateProduct(int order_id, int pro_id);

	public void saveDelivery(DeliveryDetailsBean delBean);
	
	
	
	

	public int addtoCart(Cartlist cart);

	public List<Cartlist> getCartList(int custId);

	public double calculation(int id, Cartlist cart);

	public List<Cartlist> getAllCart();

	public Cartlist update(int cartId, int qty);

	public void remove(int cartId);

	public double getFinalprice();

	public void setFinalprice(double finalprice);

	public double coupon(int order_id, int couId);
	
	public Capg_Product getProById(int pro_id);
	
	
}
