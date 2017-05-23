package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.UserCredentialDao;
import edu.mum.domain.UserCredential;
import edu.mum.service.UserCredentialService;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialService {

	@Autowired
	private UserCredentialDao userCredentialDao;
	
	@Override
	public void save(UserCredential UserCredential) {
		userCredentialDao.save(UserCredential);
	}

	@Override
	public void update(UserCredential UserCredential) {
		userCredentialDao.update(UserCredential);
	}

	@Override
	public void delete(UserCredential UserCredential) {	
		userCredentialDao.deleteUserCredentialByUsername(UserCredential.getUsername());
	}

	@Override
	public void deleteByUsername(String username) {
		userCredentialDao.deleteUserCredentialByUsername(username);
	}

	@Override
	public UserCredential findUserCredentialById(Long UserCredentialId) {
		return userCredentialDao.findOne(UserCredentialId);
	}

	@Override
	public List<UserCredential> findAll() {
		return userCredentialDao.findAll();
	}

}
