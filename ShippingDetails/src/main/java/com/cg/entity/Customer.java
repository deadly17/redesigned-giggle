package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_alu")
public class Customer {

	@Id
	@GeneratedValue
	int customer_id;

	@Column(length = 25)
	String customer_name;

	@Column(length = 30)
	String customer_email;

	long customer_phone;

	@Column(length = 30)
	String customer_address;

	long customer_aadhar;

	public int getCustomer_id() {
		return customer_id;
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

	public long getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(long customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public long getCustomer_aadhar() {
		return customer_aadhar;
	}

	public void setCustomer_aadhar(long customer_aadhar) {
		this.customer_aadhar = customer_aadhar;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

}