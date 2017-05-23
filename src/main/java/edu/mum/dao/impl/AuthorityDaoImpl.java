package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;

@Repository
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AuthorityDao {

	public AuthorityDaoImpl() {
		super.setDaoType(Authority.class);
	}

}
