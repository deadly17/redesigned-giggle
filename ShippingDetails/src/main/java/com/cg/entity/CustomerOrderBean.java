package com.cg.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="customer_order")
public class CustomerOrderBean {
	@Id
	@GeneratedValue(generator="cust_seq")
	private int order_id;
	
	@Column(name="pro_id")
	private int pro_id;
	
	@Column(length=30)
	private String pro_name;
	
	@Column(length=30)
	private double price;
	
	
	@Temporal(TemporalType.DATE)
	@Column(length=20)
	private Date order_date;
	
	@Column(length=20)
	private String payment_mode;
	
	@Column(length=20)
	private String delivered_address;
	
	@Column(length=10)
	private int customer_id;
	
	
	@Column(length=10)
	private int quantity;
	
	
	@Column(name="merchant_id")
	private int merchant_id;
	
	public CustomerOrderBean() {
		// TODO Auto-generated constructor stub
	}

	
	public CustomerOrderBean(int order_id, int pro_id, String pro_name, double price, Date order_date,
			String payment_mode, String delivered_address, int customer_id, int quantity, int merchant_id) {
		super();
		this.order_id = order_id;
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.price = price;
		this.order_date = order_date;
		this.payment_mode = payment_mode;
		this.delivered_address = delivered_address;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.merchant_id = merchant_id;
	}


	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getDelivered_address() {
		return delivered_address;
	}

	public void setDelivered_address(String delivered_address) {
		this.delivered_address = delivered_address;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}


	@Override
	public String toString() {
		return "CustomerOrderBean [order_id=" + order_id + ", pro_id=" + pro_id + ", pro_name=" + pro_name + ", price="
				+ price + ", order_date=" + order_date + ", payment_mode=" + payment_mode + ", delivered_address="
				+ delivered_address + ", customer_id=" + customer_id + ", quantity=" + quantity + ", merchant_id="
				+ merchant_id + "]";
	}

	

	
	
	
	

}
