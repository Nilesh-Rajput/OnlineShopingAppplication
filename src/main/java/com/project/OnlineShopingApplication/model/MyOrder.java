package com.project.OnlineShopingApplication.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class MyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime localdtetime;
	String orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	List<Products>productlist;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
	
	public MyOrder() {
		// TODO Auto-generated constructor stub
	}

	public MyOrder(Integer orderid, LocalDateTime localdtetime, String orderstatus, Customer customer,
			List<Products> productlist, Address address) {
		super();
		this.orderid = orderid;
		this.localdtetime = localdtetime;
		this.orderstatus = orderstatus;
		this.customer = customer;
		this.productlist = productlist;
		this.address = address;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public LocalDateTime getLocaldtetime() {
		return localdtetime;
	}

	public void setLocaldtetime(LocalDateTime localdtetime) {
		this.localdtetime = localdtetime;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Products> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Products> productlist) {
		this.productlist = productlist;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MyOrder [orderid=" + orderid + ", localdtetime=" + localdtetime + ", orderstatus=" + orderstatus
				+ ", customer=" + customer + ", productlist=" + productlist + ", address=" + address + "]";
	}
	
	
}
