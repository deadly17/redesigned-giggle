package com.cg.entity;

import javax.persistence.*;

@Entity
@Table(name="shipping_details")
public class ShippingDetailsBean {
	
	@Id
	@GeneratedValue(generator="ship_seq")
	private int shipping_id;
	
	@Column(length=30)
	private String cust_name;
	
	@Column(length=20)
	private String flat_no;
	
	@Column(length=20)
	private String road_name;
	
	@Column(length=20)
	private String area_name;
	
	@Column(length=20)
	private String city;
	
	@Column(length=20)
	private String state;
	
	@Column(length=6)
	private int pincode;
	
	@Column(length=30)
	private String email_id;
	
	@Column(length=10)
	private long phone_no;	
	
	private int customer_id;
	
	public ShippingDetailsBean() {
		// TODO Auto-generated constructor stub
	}

	

	public ShippingDetailsBean(int shipping_id, String cust_name, String flat_no, String road_name, String area_name,
			String city, String state, int pincode, String email_id, long phone_no, int customer_id) {
		super();
		this.shipping_id = shipping_id;
		this.cust_name = cust_name;
		this.flat_no = flat_no;
		this.road_name = road_name;
		this.area_name = area_name;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.email_id = email_id;
		this.phone_no = phone_no;
		this.customer_id = customer_id;
	}



	public int getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
	}

	public String getRoad_name() {
		return road_name;
	}

	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}


	@Override
	public String toString() {
		return "ShippingDetailsBean [shipping_id=" + shipping_id + ", cust_name=" + cust_name + ", flat_no=" + flat_no
				+ ", road_name=" + road_name + ", area_name=" + area_name + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", email_id=" + email_id + ", phone_no=" + phone_no + ", customer="
				+ customer_id + "]";
	}
	
	
	
	

}
