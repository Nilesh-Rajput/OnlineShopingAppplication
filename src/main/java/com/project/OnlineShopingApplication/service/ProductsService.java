package com.project.OnlineShopingApplication.service;

import java.util.List;

import com.project.OnlineShopingApplication.model.CategoryEnum;
import com.project.OnlineShopingApplication.model.Products;
import com.project.OnlineShopingApplication.model.ProductsDTO;

public interface ProductsService {
	
	public Products addProducts(Products products);
	
	public List<Products> getAllProducts();
	
	public Products getProductsFromCatalogById(Integer id);
	
	//public List<ProductsDTO> getCategoryWiseProducts(CategoryEnum cat);
	
	public String deleteProductFromCatalog(Integer id);
	
	public Products updateProductIncatalog(Products product);
}
