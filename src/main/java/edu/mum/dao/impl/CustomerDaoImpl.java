package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super.setDaoType(Customer.class);
	}
	
}
