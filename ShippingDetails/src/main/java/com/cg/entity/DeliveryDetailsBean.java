package com.cg.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="delivery_details")
public class DeliveryDetailsBean {
	
	@Id
	@GeneratedValue(generator="del_seq")
	private int d_id;
	
	
	@Column(name="customer_id")
	private int customer_id;
	

	@Column(name="pro_id")
	private int pro_id;
	
	@Column(length=30)
	private String pro_name;
	
	@Column(length=10)
	private double price;
	
	@Column(length=20)
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(length=20)
	private Date order_date;
	

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="merchant_id")
	private int merchant_id;
	
	
	@Column(length=20)
	private String delivered_address;
	
	public DeliveryDetailsBean() {
		// TODO Auto-generated constructor stub
	}



	public DeliveryDetailsBean(int d_id, int customer_id, int pro_id, String pro_name, double price, String status,
			Date order_date, int quantity, int merchant_id, String delivered_address) {
		super();
		this.d_id = d_id;
		this.customer_id = customer_id;
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.price = price;
		this.status = status;
		this.order_date = order_date;
		this.quantity = quantity;
		this.merchant_id = merchant_id;
		this.delivered_address = delivered_address;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getDelivered_address() {
		return delivered_address;
	}

	public void setDelivered_address(String delivered_address) {
		this.delivered_address = delivered_address;
	}



	@Override
	public String toString() {
		return "DeliveryDetailsBean [d_id=" + d_id + ", customer_id=" + customer_id + ", pro_id=" + pro_id
				+ ", pro_name=" + pro_name + ", price=" + price + ", status=" + status + ", order_date=" + order_date
				+ ", quantity=" + quantity + ", merchant_id=" + merchant_id + ", delivered_address=" + delivered_address
				+ "]";
	}

	

	
	
	
	

}
