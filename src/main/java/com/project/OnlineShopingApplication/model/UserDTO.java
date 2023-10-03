package com.project.OnlineShopingApplication.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class UserDTO {
	
	@NotNull(message = "Enter Your Mobile Number")
	@Pattern(regexp = "[7896]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobileNo;
	@NotNull(message = "Enter Your Password")
	private String password;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(
			@NotNull(message = "Enter Your Mobile Number") @Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Input a valid mobile number") String mobileNo,
			@NotNull(message = "Enter Your Password") String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [mobileNo=" + mobileNo + ", password=" + password + "]";
	}
	
	
	
}
