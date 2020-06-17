package com.cg.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "wish_list1")
public class WishList {
	
	@Id
	@GeneratedValue
	private int wishId;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Capg_Product product;
	
	
	private int cust_id;
     public WishList() {
	// TODO Auto-generated constructor stub
}
	
	
	public WishList(Capg_Product product, int cust_id) {
		super();
		this.product = product;
		this.cust_id = cust_id;
	}
	public int getWishId() {
		return wishId;
	}
	public void setWishId(int wishId) {
		this.wishId = wishId;
	}
	
	public Capg_Product getProduct() {
		return product;
	}
	public void setProduct(Capg_Product product) {
		this.product = product;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	@Override
	public String toString() {
		return "WishList [wishId=" + wishId + ", product=" + product + ", cust_id=" + cust_id + "]";
	}
	
	
	
	
	

}
