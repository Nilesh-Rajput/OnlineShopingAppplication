package com.project.OnlineShopingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.OnlineShopingApplication.exception.CustomerNotFoundException;
import com.project.OnlineShopingApplication.exception.ProductNotFoundException;
import com.project.OnlineShopingApplication.model.Cart;
import com.project.OnlineShopingApplication.model.Customer;
import com.project.OnlineShopingApplication.model.Products;
import com.project.OnlineShopingApplication.model.User;
import com.project.OnlineShopingApplication.repository.AddressDao;
import com.project.OnlineShopingApplication.repository.CartDao;
import com.project.OnlineShopingApplication.repository.CurrentUserSessionDao;
import com.project.OnlineShopingApplication.repository.CustomerDao;
import com.project.OnlineShopingApplication.repository.ProductsDao;
import com.project.OnlineShopingApplication.repository.UserDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private ProductsDao pDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao custDao;
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public Cart AddProduct(Cart cart, Integer Productid, Integer customerId) {
		
		Optional<Products> opt=pDao.findById(Productid);
		Optional<Customer> customer=custDao.findById(customerId);
		
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("customer not found");
		}
		User user=  userDao.findByMobile(customer.get().getMobileNumber());
		String logedinOrNot = currentUserSessionDao.findByUserId(user.getUserId());
		
		if(logedinOrNot==null) {
			throw new CustomerNotFoundException("Customer not logged in");
		}
		if(opt.isPresent()) {
			
			Products prod=opt.get();
			Customer cust=customer.get();
			
			
			
			cart.setCartItem(prod);
			cart.setCustomerlist(cust);
//			for(Customer cust:customer) {				
//				custDao.save(cust);				
//			}	
			return cartDao.save(cart);
		}else {
			throw new ProductNotFoundException("Product not available");
		}
	}

	@Override
	public String deleteProductfromCart(Integer id) {
		Optional<Cart> opt = cartDao.findById(id);
		
		if (opt.isPresent()) {
			Cart cart = opt.get();
//			System.out.println(prod);
			cartDao.delete(cart);
			return "CartProduct is deleted from Cart";
			
		} else {
			throw new ProductNotFoundException("Product not found with given id");
		}
				
	}

	private Cart cart;
	@Override
	@Transactional
	public void deleteAllCart() {
		// TODO Auto-generated method stub
		cartDao.DeleteAll();
//		return "Cart is empty";
	}
	
	@Override
	public List<Cart> ViewAllCart() {
		
		List<Cart> list=cartDao.findAll();
		
		
		return list;
	}
}
