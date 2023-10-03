package com.project.OnlineShopingApplication.service;

import com.project.OnlineShopingApplication.model.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User updateUserCredential(User user,String key);
	
	public String userLogout(String key);
}
