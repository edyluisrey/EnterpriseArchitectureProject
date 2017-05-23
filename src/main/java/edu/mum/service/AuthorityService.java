package edu.mum.service;

import java.util.List;

import edu.mum.domain.Authority;

public interface AuthorityService {

	public void save(Authority Authority);
	
	public void update(Authority Authority);
	
	public void delete(Authority Authority);
	
	public void deleteById(Long AuthorityId);
	
	public Authority findAuthorityById(Long AuthorityId);
	
	public List<Authority> findAll();
	
}
