package com.eliatech.stockmanagement.productservice.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	Product getByProductIdAndDeletedFalse(Long productId);
	
	List<Product> getAllByDeletedFalse();
	

}
