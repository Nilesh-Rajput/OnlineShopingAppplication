package com.project.OnlineShopingApplication.service;

import java.util.List;

import com.project.OnlineShopingApplication.model.Address;
import com.project.OnlineShopingApplication.model.Customer;

public interface CustomerService {
	
public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer removeCustomer(Customer customer);
	
	public Customer viewCustomer(Integer id);
	
	public List<Customer> viewAllCustomerByLocation(String location);
	
	public Customer addAddress(Address address,Integer customerId);
}
