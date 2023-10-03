package com.project.OnlineShopingApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.OnlineShopingApplication.model.CurrentUserSession;

@Repository
public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	public Optional<CurrentUserSession> findById(Integer userId);
	   
	   public CurrentUserSession  findByUniqueId(String uniqueId);
	   
	   @Query("select c.Id from CurrentUserSession c where c.UserId=?1")
	   public String findByUserId(Integer userId);
}
