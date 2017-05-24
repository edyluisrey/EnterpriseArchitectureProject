package edu.mum.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Address;

public interface AddressService {
	@PreAuthorize("ROLE_ADMIN")
	public void save(Address address);
	@PreAuthorize("ROLE_ADMIN")
	public void update(Address address);
	@Secured("ROLE_ADMIN")
	public void delete(Address address);
	@Secured("ROLE_ADMIN")
	public void deleteById(Long addressId);
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Address findAddressById(Long addressId);
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Address> findAll();
	
}
