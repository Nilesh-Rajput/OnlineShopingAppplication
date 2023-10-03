package com.project.OnlineShopingApplication.exception;

public class UserAlreadyExists extends RuntimeException {
	
//	public UserAlreadyExists() {
//		// TODO Auto-generated constructor stub
//	}
	
	public UserAlreadyExists(String message) {
		super(message);
	}
}
