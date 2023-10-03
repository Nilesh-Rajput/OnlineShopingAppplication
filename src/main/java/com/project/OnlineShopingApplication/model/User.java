package com.project.OnlineShopingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer UserId;
	@NotNull(message = "Please type your name")
	private String name;
	@NotNull(message = "Please Enter your Mobile Number")
	@Pattern(regexp = "[7896]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobile;
	@NotNull(message = "Please type your password")
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, @NotNull(message = "Please type your name") String name,
			@NotNull(message = "Please Enter your Mobile Number") @Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Input a valid mobile number") String mobile,
			@NotNull(message = "Please type your password") String password) {
		super();
		UserId = userId;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
