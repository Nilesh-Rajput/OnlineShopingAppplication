package com.project.OnlineShopingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineShopingApplication.model.Address;
import com.project.OnlineShopingApplication.model.Customer;
import com.project.OnlineShopingApplication.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/")
	public Customer saveCustomerHandler(@Valid @RequestBody Customer customer) {
		
		return cService.addCustomer(customer);
	}
	
	@PutMapping("/")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		
		return cService.updateCustomer(customer);
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		
		return cService.viewCustomer(customerId);
		
	}
	
	@DeleteMapping("/")
	public Customer deleteCustomerDetails(@Valid @RequestBody Customer customer) {
		
		return cService.removeCustomer(customer);
	}
	
	@PutMapping("/addAddress/{customerId}")
	public Customer addAddressCustomer(@Valid @RequestBody Address address, @PathVariable Integer customerId) {
		return cService.addAddress(address,customerId);
	}

}
