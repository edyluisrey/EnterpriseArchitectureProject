package edu.mum.service;

import java.util.List;

import edu.mum.domain.Audit;

public interface AuditService {
	public void save(Audit audit);
	public void update(Audit audit);
	public List<Audit> findAll();
 
	public Audit findOne(Long id);
}
