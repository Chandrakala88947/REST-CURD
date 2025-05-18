package com.chandu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandu.Entity.Product;
import com.chandu.Exception.ProductNotFoundException;
import com.chandu.Repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository  productRepository;
	
	@Transactional
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Transactional
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	@Transactional
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	
	public Product getProduct(Long id) throws ProductNotFoundException {
		Optional<Product> optproduct = productRepository.findById(id);
		if(optproduct.isPresent()) return optproduct.get();
		log.error("Product is not found");
		throw new ProductNotFoundException("Product is not found");
	}
	
	
	
	
	

}
