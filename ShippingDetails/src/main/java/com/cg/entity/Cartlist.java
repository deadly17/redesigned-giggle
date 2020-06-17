package com.cg.entity;

import javax.persistence.*;

@Entity
@Table(name = "capstore_cartlist2")
public class Cartlist {

	@Id
	@GeneratedValue
	private int cartId;
	private int cust_id;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Capg_Product pro_id;

	private double tPrice;
	private int quantity;
	private double finalprice;

	public Cartlist() {
		// TODO Auto-generated constructor stub
	}

	
	public Cartlist(int cust_id, Capg_Product pro_id, double tPrice, int quantity) {
		this.cust_id = cust_id;
		this.pro_id = pro_id;
		this.tPrice = tPrice;
		this.quantity = quantity;
	}


	public double getFinalprice() {
		return finalprice;
	}


	public void setFinalprice(double finalprice) {
		this.finalprice = finalprice;
	}


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public Capg_Product getPro_id() {
		return pro_id;
	}

	public void setPro_id(Capg_Product pro_id) {
		this.pro_id = pro_id;
	}

	public double gettPrice() {
		return tPrice;
	}

	public void settPrice(double tPrice) {
		this.tPrice = tPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
