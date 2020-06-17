package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Capg_Product;
import com.cg.entity.Cartlist;
import com.cg.entity.Coupon;
import com.cg.entity.CustomerOrderBean;
import com.cg.entity.DeliveryDetailsBean;
import com.cg.entity.ShippingDetailsBean;
import com.cg.repo.CartlistRepo;
import com.cg.repo.CouponRepo;
import com.cg.repo.CustomerOrderRepo;
import com.cg.repo.DeliveryRepo;
import com.cg.repo.GenerateInvoiceRepo;
import com.cg.repo.ProductRepo;
import com.cg.repo.ShippingRepo;

@Service
@Transactional
public class ShipServiceImpl implements ShipService {

	@Autowired
	private ShippingRepo shipRepo;

//	@Autowired
//	private CartList cartRepo;
	@Autowired
	private GenerateInvoiceRepo invoiceRepo;

	@Autowired
	private DeliveryRepo delRepo;

	@Autowired
	private ProductRepo prodRepo;
	@Autowired
	private CustomerOrderRepo oRepo;

	@Autowired
	private CartlistRepo crepo;
	
	
	@Autowired
	CustomerOrderRepo orderrepo;

	@Autowired
	private CouponRepo couponRepo;

	

	public double finalprice = 0.0;

	public double getFinalprice() {
		return finalprice;
	}

	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}

	
//	public double calculation(int id, Cartlist cart) {
//		Product pro = prodRepo.findById(id).get();
//		double price1 = pro.getPrice() * cart.getQuantity();
////		System.out.println(price1);
//		double totalPrice = price1 - ((price1 * pro.getDiscount() * 1.0) / 100);
//		cart.settPrice(totalPrice);
////		System.out.println(totalPrice);
//		return totalPrice;
//	}

//	public int addtoCart(Cartlist cart) {
//		double ans = this.calculation(cart.getPro_id(), cart);
//		cart.setTotal(ans);
//		// System.out.println(ans);
//		finalprice = finalprice + ans;
//		setFinalprice(finalprice);
//		crepo.save(cart);
//		return cart.getCartId();
//	}
//
//	public List<Cartlist> getCartList(int cartId) {
//		return crepo.getCartListById(cartId);
//	}
//
//	public List<Cartlist> getAllCart() {
//		return crepo.findAll();
//	}
//	
//	public Product getProById(int proid){
//		return prodRepo.getProductById(proid);
//	}

	
	public double coupon(int order_id, int couId) {
		Coupon coupon = couponRepo.getCouponByCustomId(couId);
		CustomerOrderBean customer = orderrepo.getOrderById(order_id);
		double price = customer.getPrice() - ((customer.getPrice() * coupon.getDiscount()) / 100);
		customer.setPrice(price);
		couponRepo.deleteById(couId);

		return price;
	}

	public Cartlist update(int cartId, int qty) {
		int qty1;
		Cartlist cart = crepo.findById(cartId).get();
		if (qty > cart.getQuantity()) {
			double pre = cart.gettPrice();
			qty1 = qty - cart.getQuantity();
			cart.setQuantity(qty1);
			double pr = this.calculation(cart.getPro_id().getId(), cart);
			double price = pre + pr;
			finalprice = getFinalprice() + pr;

			cart.settPrice(price);
			cart.setQuantity(qty);
			setFinalprice(finalprice);
			crepo.save(cart);
		}

		else {
			double pre = cart.gettPrice();
			qty1 = cart.getQuantity() - qty;
			cart.setQuantity(qty1);
			double pr = this.calculation(cart.getPro_id().getId(), cart);
			double price = pre - pr;
			finalprice = getFinalprice() - price;
			cart.settPrice(pr);
			cart.setQuantity(qty);
			setFinalprice(finalprice);

			crepo.save(cart);
		}
		return cart;
	}

	public void remove(int cartId) {
		Cartlist cart = crepo.findById(cartId).get();
		finalprice = getFinalprice() - cart.gettPrice();
		setFinalprice(finalprice);
		crepo.deleteById(cartId);
	}

//	@Override
//	public boolean updateProduct(int order_id, int pro_id) {
//		CustomerOrderBean order = oRepo.findById(order_id).get();
//		CapgProduct capgProduct = prodRepo.findById(pro_id).get();
//		if (capgProduct.getStock() >= order.getQuantity()) {
//			int p = capgProduct.getStock() - order.getQuantity();
//			capgProduct.setStock(p);
//			// product.setStock(p);
//			oRepo.save(order);
//			return true;
//		} else {
//			return false;
//		}
//	}

	@Override
	public void saveDelivery(DeliveryDetailsBean delBean) {
		delRepo.save(delBean);

	}

	public List<CustomerOrderBean> generateInvoice(int custId) {
		return invoiceRepo.getInvoiceById(custId);

	}


	public List<DeliveryDetailsBean> getAll() {
		return delRepo.findAll();
	}

	public List<DeliveryDetailsBean> getById(int d_id) {
		return delRepo.find(d_id);
	}

	public List<DeliveryDetailsBean> returnGood(int d_Id) {
		DeliveryDetailsBean db = delRepo.findById(d_Id).get();
//		DeliveryDetailsBean db=delRepo.returnGood(productId);
		db.setStatus("Returned");
		int i = db.getPro_id();
		Capg_Product pd = prodRepo.findById(i).get();
		pd.setStock(pd.getStock() + db.getQuantity());
		prodRepo.save(pd);
		delRepo.save(db);
		return delRepo.findAll();

	}

	public void setDetails(ShippingDetailsBean shipDetails,int cust_id) {

		/*
		 * cartList=cartRepo.findby(cartList.class).get();
		 * shipDetails.setCustomer_Id(cartList.getCustomer_Id());
		 */
		shipDetails.setCustomer_id(cust_id);
		shipRepo.save(shipDetails);
	}

	@Override
	public List<ShippingDetailsBean> showdetails(int cust_id) {
		// TODO Auto-generated method stub
		return shipRepo.find(cust_id);
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean updateProduct(int order_id, int pro_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addtoCart(Cartlist cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cartlist> getCartList(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculation(int id, Cartlist cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cartlist> getAllCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Capg_Product getProById(int pro_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
