package edu.mum.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

  	void save(Product product);

	Product findOne(long id);
 
 

}
