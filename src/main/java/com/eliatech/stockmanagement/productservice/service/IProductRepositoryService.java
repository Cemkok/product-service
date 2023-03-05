package com.eliatech.stockmanagement.productservice.service;

import java.util.List;

import com.eliatech.stockmanagement.productservice.enums.Language;
import com.eliatech.stockmanagement.productservice.repository.entity.Product;
import com.eliatech.stockmanagement.productservice.request.ProductCreateRequest;
import com.eliatech.stockmanagement.productservice.request.ProductUpdateRequest;

public interface IProductRepositoryService {
	
	Product createProduct(Language language, ProductCreateRequest productCreateRequest );
	
	Product getProduct(Language language, Long productId);
	
	List<Product> getProducts(Language language);
	
	Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest);
	
	Product deleteProduct(Language language, Long productId);
	
	
	
	
	
	

}
