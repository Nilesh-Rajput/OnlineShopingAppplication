package com.project.OnlineShopingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineShopingApplication.exception.ProductNotFoundException;
import com.project.OnlineShopingApplication.model.CategoryEnum;
import com.project.OnlineShopingApplication.model.Products;
import com.project.OnlineShopingApplication.model.ProductsDTO;
import com.project.OnlineShopingApplication.repository.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsDao psDao;

	@Override
	public Products addProducts(Products products) {
		return psDao.save(products);

	}

	@Override
	public List<Products> getAllProducts() {
		List<Products> list = psDao.findAll();
		
		if (list.size() > 0) {
			return list;
		} else {
			throw new ProductNotFoundException("No products in catalog");
		}
	}

	@Override
	public Products getProductsFromCatalogById(Integer id) {
		Optional<Products> opt = psDao.findById(id);
		
		if (opt.isPresent()) {
			return opt.get();
		}else {
			throw new ProductNotFoundException("Product not found with given id");
		}

	}

//	@Override
//	public List<ProductsDTO> getCategoryWiseProducts(CategoryEnum cat) {
//		
//		return psDao.getCategoryWiseProducts(cat);
//	}

	@Override
	public String deleteProductFromCatalog(Integer id) {
		
		Optional<Products> opt=	psDao.findById(id);
		
		if(opt.isPresent()) {
				Products prod = opt.get();
				psDao.delete(prod);
				return "Product deleted from catalog";
			} else {
				throw new ProductNotFoundException("Product not found with given id");
			}
				
		
	}

	@Override
	public Products updateProductIncatalog(Products product) {
		
		Optional<Products> opt = psDao.findById(product.getProductId());

		if (opt.isPresent()) {
			opt.get();
			Products prod1 = psDao.save(product);
			return prod1;
		} else {
			throw new ProductNotFoundException("Product not found with given id");
		}
			
	}
}
