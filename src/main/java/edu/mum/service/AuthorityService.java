package edu.mum.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Authority;

public interface AuthorityService {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Authority Authority);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void update(Authority Authority);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(Authority Authority);
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(Long AuthorityId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public Authority findAuthorityById(Long AuthorityId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Authority> findAll();
	
}
