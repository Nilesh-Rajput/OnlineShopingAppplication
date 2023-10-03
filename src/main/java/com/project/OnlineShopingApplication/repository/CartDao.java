package com.project.OnlineShopingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.OnlineShopingApplication.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
	@Modifying
    @Query(
            value = "truncate table Cart",
            nativeQuery = true
    )
	public void DeleteAll();
	
	
//	public Cart deleteFromCart(Integer id);
}
