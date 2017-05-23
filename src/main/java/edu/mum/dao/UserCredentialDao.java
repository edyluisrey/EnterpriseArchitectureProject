package edu.mum.dao;

import edu.mum.domain.UserCredential;

public interface UserCredentialDao extends GenericDao<UserCredential> {

	public UserCredential findUserCredentialByUsername(String username);
	
	public void deleteUserCredentialByUsername(String username);
	
}
