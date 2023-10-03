package com.project.OnlineShopingApplication.service;

import java.util.List;

import com.project.OnlineShopingApplication.model.Cart;

public interface CartService {
	
	public Cart AddProduct(Cart cart,Integer Productid,Integer customerId);
	
	public String deleteProductfromCart(Integer id);
	
	public void deleteAllCart();
	
//	public String DeleteALl();
	
	public List<Cart> ViewAllCart();
	
}
