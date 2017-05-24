package edu.mum.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Customer;

public interface CustomerService {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Customer Customer);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void update(Customer Customer);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Customer Customer);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(Long CustomerId);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Customer findCustomerById(Long CustomerId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Customer> findAll();
	
}
