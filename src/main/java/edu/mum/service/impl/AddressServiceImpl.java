package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;
import edu.mum.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public void save(Address address) {
		addressDao.save(address);
	}

	@Override
	public void update(Address address) {
		addressDao.update(address);
	}

	@Override
	public void delete(Address address) {
		addressDao.delete(address.getId());
	}

	@Override
	public void deleteById(Long addressId) {
		addressDao.delete(addressId);
	}

	@Override
	public Address findAddressById(Long addressId) {
		return addressDao.findOne(addressId);
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

}
