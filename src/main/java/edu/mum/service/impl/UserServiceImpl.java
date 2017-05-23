package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;
	
	@Override
	public void save(User User) {
		UserDao.save(User);
	}

	@Override
	public void update(User User) {
		UserDao.update(User);
	}

	@Override
	public void delete(User User) {
		UserDao.delete(User.getId());
	}

	@Override
	public void deleteById(Long UserId) {
		UserDao.delete(UserId);
	}

	@Override
	public User findUserById(Long UserId) {
		return UserDao.findOne(UserId);
	}

	@Override
	public List<User> findAll() {
		return UserDao.findAll();
	}

}
