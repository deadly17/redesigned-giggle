package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coupon")
public class Coupon {
   
	@Id
	private int couId;
	private String code;
    private int discount;
    
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Coupon(String code, int discount) {
		super();
		this.code = code;
		this.discount = discount;
	}
	public Coupon() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Coupon [code=" + code + ", discount=" + discount + "]";
	}
	
	
  
}
