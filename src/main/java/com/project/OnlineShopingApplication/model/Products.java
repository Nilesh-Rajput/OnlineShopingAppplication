package com.project.OnlineShopingApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@NotNull(message = "please input a valid product name")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid product name")
	private String productName;
	@NotNull(message = "please input a valid product name")
	private Double price;
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please input a valid color")
	private String color; 
	private String dimension;
	private String specification;
	@NotNull(message = "please input a valid manufacturer")
	private String manufacturer;
	@Min(value = 1,message = "quantity should be minimum one")
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(Integer productId,
			@NotNull(message = "please input a valid product name") @Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$", message = "please input a valid product name") String productName,
			@NotNull(message = "please input a valid product name") Double price,
			@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$", message = "please input a valid color") String color,
			String dimension, String specification,
			@NotNull(message = "please input a valid manufacturer") String manufacturer,
			@Min(value = 1, message = "quantity should be minimum one") Integer quantity, CategoryEnum category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", dimension=" + dimension + ", specification=" + specification + ", manufacturer="
				+ manufacturer + ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	
}
