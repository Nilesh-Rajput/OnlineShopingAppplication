package com.project.OnlineShopingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineShopingApplication.model.CategoryEnum;
import com.project.OnlineShopingApplication.model.Products;
import com.project.OnlineShopingApplication.model.ProductsDTO;
import com.project.OnlineShopingApplication.service.ProductsService;

import jakarta.validation.Valid;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService ppService;
	
	@PostMapping("/addnewproducts")
	public Products saveProductsHandler(@Valid @RequestBody Products product) {
		
		return ppService.addProducts(product);
	}
	
	
	@GetMapping("/allproducts")
	public List<Products> getAllProducts(){
		
		return ppService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Products> getProductFromCatalogByIdHandler(@PathVariable("id") Integer id) {
		
		Products prod =  ppService.getProductsFromCatalogById(id);

		return new ResponseEntity<Products>(prod, HttpStatus.FOUND);

	}
	
	
//	@GetMapping("/products/{cat}")
//	public List<ProductsDTO> getCategoryWiseProducts(@PathVariable("cat") CategoryEnum cat) {
//	
//		return ppService.getCategoryWiseProducts(cat);
//		
//	}
	
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProductFromCatalogHandler(@PathVariable("id") Integer id) {
		
		String res = ppService.deleteProductFromCatalog(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@PutMapping("/updateproducts")
	public ResponseEntity<Products> updateProductInCatalogHandler(@Valid @RequestBody Products prod) {

		Products prod1 = ppService.updateProductIncatalog(prod);

		return new ResponseEntity<Products>(prod1, HttpStatus.OK);

	}
	
}
