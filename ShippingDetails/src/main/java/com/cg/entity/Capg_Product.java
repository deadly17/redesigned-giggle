package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CapgProduct")
public class Capg_Product {

	@Id
	@GeneratedValue(generator = "prod_seq")
	private int id;

	@Column(length = 15)
	private String name;

	@Column(length = 15)
	private String brand;

	@Column(length = 10)
	private int price;

	@Column(length = 10)
	private int discount;

	@Column(length = 10)
	private String promo_code;

	@Column(length = 7)
	private int stock;

	@Column(length = 15)
	private String category;

	@Column(length = 15)
	private String sub_category;

	@Column(length = 7)
	private int vote_count;

	@Column(length = 7)
	private int prev_vote_sum;

	@Column(length = 7)
	private int merchant_id;

	public Capg_Product(int id, String name, String brand, int price, int discount, String promo_code, int stock,
			String category, String sub_category, int vote_count, int prev_vote_sum, int merchant_id) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.discount = discount;
		this.promo_code = promo_code;
		this.stock = stock;
		this.category = category;
		this.sub_category = sub_category;
		this.vote_count = vote_count;
		this.prev_vote_sum = prev_vote_sum;
		this.merchant_id = merchant_id;
	}

	public Capg_Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPromo_code() {
		return promo_code;
	}

	public void setPromo_code(String promo_code) {
		this.promo_code = promo_code;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public int getPrev_vote_sum() {
		return prev_vote_sum;
	}

	public void setPrev_vote_sum(int prev_vote_sum) {
		this.prev_vote_sum = prev_vote_sum;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

}
