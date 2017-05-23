package edu.mum.service;

import java.util.List;

import edu.mum.domain.UserCredential;

public interface UserCredentialService {

	public void save(UserCredential UserCredential);
	
	public void update(UserCredential UserCredential);
	
	public void delete(UserCredential UserCredential);
	
	public void deleteByUsername(String username);
	
	public UserCredential findUserCredentialById(Long UserCredentialId);
	
	public List<UserCredential> findAll();
	
}
