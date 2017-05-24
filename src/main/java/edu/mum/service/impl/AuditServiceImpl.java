package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.aspect.annotation.Auditor;
import edu.mum.dao.AuditDao;
import edu.mum.domain.Audit;

@Service 
@Transactional
public class AuditServiceImpl implements edu.mum.service.AuditService{

	@Autowired
	private AuditDao auditDao;
	
	public void save(Audit audit) {
		auditDao.save(audit);
		
	}

	public void update(Audit audit) {
		auditDao.update(audit);		
	}

	
	public List<Audit> findAll() {
		System.out.println("Method findAll() called");
		return (List<Audit>)auditDao.findAll();
	}

	@Auditor
	public Audit findOne(Long id) {
		return auditDao.findOne(id);
	}
	
	public Audit findByEmail(String email){
		System.out.println("Method findByEmail() called");
        //Throwing an exception
        throw new NullPointerException("email not found");
	}

}
