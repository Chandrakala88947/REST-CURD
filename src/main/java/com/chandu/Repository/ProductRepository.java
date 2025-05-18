package com.chandu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandu.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
