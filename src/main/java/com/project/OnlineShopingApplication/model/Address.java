package com.project.OnlineShopingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull(message = "please fill sreeet number")
	private String streetNo;
	@NotNull(message = "please fill Building name")
	private String buildingName;
	@NotNull(message = "please fill City name")
	private String city;
	@NotNull(message = "please fill state name")
	private String state;
	@NotNull(message = "please fill country name")
	private String country;
	@Pattern(regexp = "([1-9]{1}[0-9]{5}|[1-9]{1}[0-9]{3}\\\\s[0-9]{3})",message = "please input a valid pincode")
	private String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addressId, @NotNull(message = "please fill sreeet number") String streetNo,
			@NotNull(message = "please fill Building name") String buildingName,
			@NotNull(message = "please fill City name") String city,
			@NotNull(message = "please fill state name") String state,
			@NotNull(message = "please fill country name") String country,
			@Pattern(regexp = "([1-9]{1}[0-9]{5}|[1-9]{1}[0-9]{3}\\\\s[0-9]{3})", message = "please input a valid pincode") String pincode) {
		super();
		this.addressId = addressId;
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNo=" + streetNo + ", buildingName=" + buildingName
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
	

}
