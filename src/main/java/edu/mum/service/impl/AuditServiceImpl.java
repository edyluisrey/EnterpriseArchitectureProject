package edu.mum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.domain.Audit;
import edu.mum.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService{


	public void save(Audit audit) {
		// TODO Auto-generated method stub
		
	}


	public void update(Audit audit) {
		// TODO Auto-generated method stub
		
	}


	public List<Audit> findAll() {
		// TODO Auto-generated method stub
		 System.out.println("findAll == init");
		    
		 List<Audit> list = new ArrayList<>();		    
		 for (int i = 0; i < 10; i++) {
			 Audit audit = new Audit();
			 audit.setWho("edy"+i);
			 list.add(audit);
			 
		 }
		 System.out.println("findAll == return");
		return null;
	}

	
	public Audit findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
