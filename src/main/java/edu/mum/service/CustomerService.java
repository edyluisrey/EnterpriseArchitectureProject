package edu.mum.service;

import java.util.List;

import edu.mum.domain.Customer;

public interface CustomerService {

	public void save(Customer Customer);
	
	public void update(Customer Customer);
	
	public void delete(Customer Customer);
	
	public void deleteById(Long CustomerId);
	
	public Customer findCustomerById(Long CustomerId);
	
	public List<Customer> findAll();
	
}
