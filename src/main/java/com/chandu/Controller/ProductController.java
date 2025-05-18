package com.chandu.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandu.Entity.Product;
import com.chandu.Exception.ProductNotFoundException;
import com.chandu.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curd")
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@PostMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		
	}
	
	@GetMapping("/getall")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	@GetMapping("/getproduct/{id}")
	public Product getProduct(@PathVariable Long id) throws ProductNotFoundException {
		return productService.getProduct(id);
	}
	
	

}
