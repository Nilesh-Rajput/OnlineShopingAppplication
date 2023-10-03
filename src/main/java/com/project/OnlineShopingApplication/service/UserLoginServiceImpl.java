package com.project.OnlineShopingApplication.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineShopingApplication.exception.UserAlreadyExists;
import com.project.OnlineShopingApplication.model.CurrentUserSession;
import com.project.OnlineShopingApplication.model.User;
import com.project.OnlineShopingApplication.model.UserDTO;
import com.project.OnlineShopingApplication.repository.CurrentUserSessionDao;
import com.project.OnlineShopingApplication.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private CurrentUserSessionDao currentusersessionDao;
	
	@Autowired
	private UserDao uDao;
	
	@Override
	public String userLogin(UserDTO userDto) {
		
		User u = uDao.findByMobile(userDto.getMobileNo());

		if(u==null) {
			return "Enter a valid mobile number";
		}
		Optional<CurrentUserSession> opt1 = currentusersessionDao.findById(u.getUserId());
		if(opt1.isPresent()) {
			throw new UserAlreadyExists("User Already loged in");
		}
		
		if(u.getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(u.getUserId(), key,LocalDateTime.now());
			currentusersessionDao.save(currentUserSession);
			return currentUserSession.toString();
			
		}else return "Password does not match";
	}

}
