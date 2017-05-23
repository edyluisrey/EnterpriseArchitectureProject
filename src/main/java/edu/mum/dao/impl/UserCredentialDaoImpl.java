package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserCredentialDao;
import edu.mum.domain.UserCredential;

@Repository
public class UserCredentialDaoImpl extends GenericDaoImpl<UserCredential> implements UserCredentialDao {

	public UserCredentialDaoImpl() {
		super.setDaoType(UserCredential.class);
	}

	@Override
	public UserCredential findUserCredentialByUsername(String username) {
		Query query = entityManager.createQuery("SELECT u FROM usercredential u WHERE u.username = :username");
		return (UserCredential)query.setParameter("username", username).getSingleResult();
	}

	@Override
	public void deleteUserCredentialByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("DELETE * FROM usercredential u WHERE u.username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
	}
	
	
}
