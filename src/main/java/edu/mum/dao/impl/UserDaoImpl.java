package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class);
	}
	
}
