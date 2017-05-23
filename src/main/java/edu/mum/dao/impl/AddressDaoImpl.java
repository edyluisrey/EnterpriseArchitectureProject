package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(Address.class);
	}
	
}
