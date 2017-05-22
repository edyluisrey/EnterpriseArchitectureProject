package edu.mum.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Product;

 

public interface ProductRepositoryLite {

	List <Product> getAllProducts();
	
	Product getProductById(String key);
	
	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);		
}
