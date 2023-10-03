package com.project.OnlineShopingApplication.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class CurrentUserSession {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column(unique = true)
	private Integer UserId;
	
	private String uniqueId;
	
	private LocalDateTime time;
	
	public CurrentUserSession() {
		// TODO Auto-generated constructor stub
	}

	public CurrentUserSession(Integer userId, String uniqueId, LocalDateTime time) {
		super();
		UserId = userId;
		this.uniqueId = uniqueId;
		this.time = time;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [Id=" + Id + ", UserId=" + UserId + ", uniqueId=" + uniqueId + ", time=" + time
				+ "]";
	}
	
	
}
