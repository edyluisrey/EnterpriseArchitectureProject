package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Auditor;
import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao CustomerDao;
	
	@Auditor
	@Override
	public void save(Customer Customer) {
		CustomerDao.save(Customer);
	}
    
	@Auditor
	@Override
	public void update(Customer Customer) {
		CustomerDao.update(Customer);
	}
    
	@Auditor
	@Override
	public void delete(Customer Customer) {
		CustomerDao.delete(Customer.getId());
	}

	@Override
	public void deleteById(Long CustomerId) {
		CustomerDao.delete(CustomerId);
	}

	@Override
	public Customer findCustomerById(Long CustomerId) {
		return CustomerDao.findOne(CustomerId);
	}

	@Override
	public List<Customer> findAll() {
		return CustomerDao.findAll();
	}

}
