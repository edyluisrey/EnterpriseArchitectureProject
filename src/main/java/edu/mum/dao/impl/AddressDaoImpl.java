package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(Address.class );
		}

 
 }