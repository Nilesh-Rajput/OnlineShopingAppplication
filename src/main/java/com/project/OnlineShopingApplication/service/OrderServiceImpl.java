package com.project.OnlineShopingApplication.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineShopingApplication.exception.CustomerNotFoundException;
import com.project.OnlineShopingApplication.model.Cart;
import com.project.OnlineShopingApplication.model.Customer;
import com.project.OnlineShopingApplication.model.MyOrder;
import com.project.OnlineShopingApplication.model.Products;
import com.project.OnlineShopingApplication.model.User;
import com.project.OnlineShopingApplication.repository.AddressDao;
import com.project.OnlineShopingApplication.repository.CartDao;
import com.project.OnlineShopingApplication.repository.CurrentUserSessionDao;
import com.project.OnlineShopingApplication.repository.CustomerDao;
import com.project.OnlineShopingApplication.repository.OrderDao;
import com.project.OnlineShopingApplication.repository.ProductsDao;
import com.project.OnlineShopingApplication.repository.UserDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao currUserSessDao;
	
	@Autowired
	private	ProductsDao productDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	 private CartService cartService;

//	@Override
//	public MyOrder addOrder(MyOrder order, Integer customerId, Integer addressId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<MyOrder> viewOrder() {
		List<MyOrder>allOrder=orderdao.findAll();
		return allOrder;
	}

	@Override
	public MyOrder viewOrderByCustomerId(Integer custiomerId) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getCustomerId()==custiomerId) {
			return order;
			}
		}
		throw new CustomerNotFoundException("Order not found");
		
	}

	@Override
	public List<MyOrder> findOrderByUserName(String FirstName, String LastName, String mobileNo) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		List<MyOrder>findAllByName=new ArrayList<MyOrder>();
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getFirstName().equals(FirstName)&& order.getCustomer().getLastName().equals(LastName)&&order.getCustomer().getMobileNumber().equals(mobileNo) ) {
			findAllByName.add(order);
			}
			
		}
//		System.out.println(findAllByName);
		if(findAllByName.size()==0) {
			throw new CustomerNotFoundException("Order not found");
		}else {
			return findAllByName;
		}
	}

	@Override
	public MyOrder updateOrder(Integer custiomerId, MyOrder order) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		int count=0;
		MyOrder findord=new MyOrder();
		for(MyOrder find:allOrder) {
			if(find.getCustomer().getCustomerId()==custiomerId) {
				findord=find;
				count++;
			}

		}
		if(count==0) {
			throw new CustomerNotFoundException("Order not found");
		}
	
		
		
		List<Products> products2=order.getProductlist();
		List<Products> products = findord.getProductlist();
		return findord;
	}

	@Override
	public String removeOrder(Integer custiomerId) {
		
		List<MyOrder>allOrder=orderdao.findAll();
		
		
		for(MyOrder order:allOrder) {
			if(order.getCustomer().getCustomerId()==custiomerId) {
//			 orderdao.delete(order);
				
				User user=  userDao.findByMobile(order.getCustomer().getMobileNumber());
				String logedinOrNot = currUserSessDao.findByUserId(user.getUserId());
				if(logedinOrNot==null) {
					throw new CustomerNotFoundException("Customer not logged in");
				}
				order.setCustomer(null);
				order.setProductlist(null);
				orderdao.save(order);
				System.out.println(order);
				orderdao.delete(order);
				
			 return "order canceled";
			}
		}
		
		throw new CustomerNotFoundException("Order not found");
	}

	@Override
	public MyOrder addorderFromCart(Integer customerId) {
		
		MyOrder myOrder=new MyOrder();
		Cart cart=new Cart();
		List<Cart> allCartDetails=cartServiceImpl.ViewAllCart();
		List<Products>getProducts=new ArrayList<>();
		
		for(Cart newCart:allCartDetails) {
			if(newCart.getCustomerlist().getCustomerId()==(customerId)) {
				getProducts.add(newCart.getCartItem());
				allCartDetails.remove(newCart.getCartItem());
			}
			
		}
		System.out.println(getProducts);
		myOrder.setLocaldtetime(LocalDateTime.now());
		myOrder.setOrderstatus("ORDER PLACED");
		
		Optional<Customer>opt=customerDao.findById(customerId);
		
		if(opt.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with this Id"+customerId);
		}
		myOrder.setCustomer(opt.get());
		myOrder.setProductlist(getProducts);

		MyOrder myOrder2= orderdao.save(myOrder);
//		cartService.deleteAllCart();
		
		return myOrder2;
	}
	
	
	
	
	
}
