package com.project.OnlineShopingApplication.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProductsDTO {
	
	@NotNull(message = "please input a valid product name")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid product name")
	private String productName;
	@NotNull(message = "please input a valid product name")
	private Double price;
	
	public ProductsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductsDTO(
			@NotNull(message = "please input a valid product name") @Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$", message = "please input a valid product name") String productName,
			@NotNull(message = "please input a valid product name") Double price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductsDTO [productName=" + productName + ", price=" + price + "]";
	}
	
	
}
