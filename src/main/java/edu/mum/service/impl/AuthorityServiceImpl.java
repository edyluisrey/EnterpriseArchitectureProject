package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import edu.mum.service.AuthorityService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao AuthorityDao;
	
	@Override
	public void save(Authority Authority) {
		AuthorityDao.save(Authority);
	}

	@Override
	public void update(Authority Authority) {
		AuthorityDao.update(Authority);
	}

	@Override
	public void delete(Authority Authority) {
		AuthorityDao.delete(Authority.getId());
	}

	@Override
	public void deleteById(Long AuthorityId) {
		AuthorityDao.delete(AuthorityId);
	}

	@Override
	public Authority findAuthorityById(Long AuthorityId) {
		return AuthorityDao.findOne(AuthorityId);
	}

	@Override
	public List<Authority> findAll() {
		return AuthorityDao.findAll();
	}

}
