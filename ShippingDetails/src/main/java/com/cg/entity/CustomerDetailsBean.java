package com.cg.entity;

import javax.persistence.*;

@Entity
@Table(name = "capstore_customers")
public class CustomerDetailsBean {
	@Id
	@SequenceGenerator(name = "cs", sequenceName = "customer_sequence")
	private int customer_id;
	@Column(length = 15)
	private String customer_name;
	@Column(length = 30)
	private String customer_email;
	@Column(length = 12)
	private String customer_aadhar;
	@Column(length = 10)
	private Long customer_phone;
	@Column(length = 50)
	private String customer_address;
    @Column(name="id")
	private int login_id;
	  
	public CustomerDetailsBean() {
	}

	public CustomerDetailsBean(int customer_id, String customer_name, String customer_email, String customer_aadhar,
			Long customer_phone, String customer_address, int login_id) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.customer_aadhar = customer_aadhar;
		this.customer_phone = customer_phone;
		this.customer_address = customer_address;
		this.login_id = login_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_aadhar() {
		return customer_aadhar;
	}

	public void setCustomer_aadhar(String customer_aadhar) {
		this.customer_aadhar = customer_aadhar;
	}

	public Long getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(Long customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "CustomerDetailsBean [customer_id=" + customer_id + ", customer_name=" + customer_name
				+ ", customer_email=" + customer_email + ", customer_aadhar=" + customer_aadhar + ", customer_phone="
				+ customer_phone + ", customer_address=" + customer_address + ", login_id=" + login_id + "]";
	}

	
}

