package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="capstore_login")
public class LoginDetailsBean {
	
	@Id
	@GeneratedValue(generator="login_seq")
	private int id;
	
	@Column(length=30)
	private String username;
	
	@Column(length=15)
	private String password;
	
	@Column(length=5)
	private String account_type;
	
	public LoginDetailsBean() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetailsBean(int id, String username, String password, String account_type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.account_type = account_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "LoginDetailsBean [id=" + id + ", username=" + username + ", password=" + password + ", account_type="
				+ account_type + "]";
	}
	
	
	
	

}
