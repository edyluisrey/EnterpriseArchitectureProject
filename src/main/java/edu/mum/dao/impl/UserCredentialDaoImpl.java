package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserCredentialDao;
import edu.mum.domain.UserCredential;

@Repository
public class UserCredentialDaoImpl extends GenericDaoImpl<UserCredential> implements UserCredentialDao {

	public UserCredentialDaoImpl() {
		super.setDaoType(UserCredential.class);
	}
	
}
