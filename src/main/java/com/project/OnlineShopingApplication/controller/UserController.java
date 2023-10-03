package com.project.OnlineShopingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineShopingApplication.model.User;
import com.project.OnlineShopingApplication.model.UserDTO;
import com.project.OnlineShopingApplication.service.UserLoginService;
import com.project.OnlineShopingApplication.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private UserLoginService ulogService;
	
	@PostMapping("/registration")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		User responseUser = uService.saveUser(user);
		return new  ResponseEntity<User>(responseUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> userLoginC(@Valid @RequestBody UserDTO userDto) {
		String msg =  ulogService.userLogin(userDto);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateUser/{key}")
	public ResponseEntity<User> updateUserCredentialController(@Valid @RequestBody User user, @PathVariable String key) {
		User responseUser =  uService.updateUserCredential(user, key);
		return new ResponseEntity<User>(responseUser,HttpStatus.ACCEPTED);
	}
	 
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> userLogoutController(@Valid @PathVariable String key) {
		String msg =  uService.userLogout(key);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
}
