package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AuditDao;
import edu.mum.domain.Audit;

@SuppressWarnings("unchecked")
@Repository
public class AuditDaoImpl extends GenericDaoImpl<Audit> implements AuditDao {
	   
	  public AuditDaoImpl() {
		   super.setDaoType(Audit.class );
	   }
}
