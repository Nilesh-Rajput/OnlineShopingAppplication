package com.project.OnlineShopingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;	
	
	@OneToOne
	private Products cartItem;
	
	@OneToOne
	private Customer customerlist;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer cartItemId, Products cartItem, Customer customerlist) {
		super();
		this.cartItemId = cartItemId;
		this.cartItem = cartItem;
		this.customerlist = customerlist;
	}

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Products getCartItem() {
		return cartItem;
	}

	public void setCartItem(Products cartItem) {
		this.cartItem = cartItem;
	}

	public Customer getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(Customer customerlist) {
		this.customerlist = customerlist;
	}

	@Override
	public String toString() {
		return "Cart [cartItemId=" + cartItemId + ", cartItem=" + cartItem + ", customerlist=" + customerlist + "]";
	}
	
	
	
	
}
