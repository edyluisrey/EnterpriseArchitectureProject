package edu.mum.service;

import java.util.List;

import edu.mum.domain.Address;

public interface AddressService {

	public void save(Address address);
	
	public void update(Address address);
	
	public void delete(Address address);
	
	public void deleteById(Long addressId);
	
	public Address findAddressById(Long addressId);
	
	public List<Address> findAll();
	
}
