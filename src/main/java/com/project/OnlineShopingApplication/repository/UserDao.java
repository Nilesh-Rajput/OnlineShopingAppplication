package com.project.OnlineShopingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.OnlineShopingApplication.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findByMobile(String mobile);
}
