package com.project.OnlineShopingApplication.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer customerId;
	@NotNull(message = "please input a valid name")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid name")
	private String firstName;
	@NotNull(message = "please input a valid name")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid name")
	private String lastName;
	@NotNull(message = "Please Enter your Mobile Number")
	@Pattern(regexp = "[7896]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobileNumber;
	@Pattern(regexp = "^(.+)@(\\S+)$",message = "Input a valid email address")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresslist= new ArrayList<>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer customerId,
			@NotNull(message = "please input a valid name") @Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$", message = "please input a valid name") String firstName,
			@NotNull(message = "please input a valid name") @Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$", message = "please input a valid name") String lastName,
			@NotNull(message = "Please Enter your Mobile Number") @Pattern(regexp = "[7896]{1}[0-9]{9}", message = "Input a valid mobile number") String mobileNumber,
			@Pattern(regexp = "^(.+)@(\\S+)$", message = "Input a valid email address") String email,
			List<Address> addresslist) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.addresslist = addresslist;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", addresslist=" + addresslist + "]";
	}
	
	
}
