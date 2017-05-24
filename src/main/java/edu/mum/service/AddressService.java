package edu.mum.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Address;

public interface AddressService {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	
	public void save(Address address);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void update(Address address);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Address address);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(Long addressId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public Address findAddressById(Long addressId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Address> findAll();
	
}
