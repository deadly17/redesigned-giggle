package com.cg.entity;

import javax.persistence.*;

@Entity
@Table(name="capstore_merchants")
public class MerchantDetailsBean {
	
	@Id
	@SequenceGenerator(name = "ms", sequenceName = "merchant_sequence")
	private int merchant_id;
	@Column(length = 15)
	private String merchant_name;
	@Column(length = 30)
	private String merchant_email;
	@Column(length = 10)
	private Long merchant_phone;
	@Column(length = 50)
	private String merchant_address;
    @Column(length=5)
	private String merchant_type;
    
   
	@Column(name="id")
	private int id;
    
    public MerchantDetailsBean() {
		// TODO Auto-generated constructor stub
	}

	public MerchantDetailsBean(int merchant_id, String merchant_name, String merchant_email, Long merchant_phone,
			String merchant_address, String merchant_type, int id) {
		super();
		this.merchant_id = merchant_id;
		this.merchant_name = merchant_name;
		this.merchant_email = merchant_email;
		this.merchant_phone = merchant_phone;
		this.merchant_address = merchant_address;
		this.merchant_type = merchant_type;
		this.id = id;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}

	public Long getMerchant_phone() {
		return merchant_phone;
	}

	public void setMerchant_phone(Long merchant_phone) {
		this.merchant_phone = merchant_phone;
	}

	public String getMerchant_address() {
		return merchant_address;
	}

	public void setMerchant_address(String merchant_address) {
		this.merchant_address = merchant_address;
	}

	public String getMerchant_type() {
		return merchant_type;
	}

	public void setMerchant_type(String merchant_type) {
		this.merchant_type = merchant_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MerchantDetailsBean [merchant_id=" + merchant_id + ", merchant_name=" + merchant_name
				+ ", merchant_email=" + merchant_email + ", merchant_phone=" + merchant_phone + ", merchant_address="
				+ merchant_address + ", merchant_type=" + merchant_type + ", id=" + id + "]";
	}

	
}
