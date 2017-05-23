package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;

public interface UserService {

	public void save(User User);
	
	public void update(User User);
	
	public void delete(User User);
	
	public void deleteById(Long UserId);
	
	public User findUserById(Long UserId);
	
	public List<User> findAll();
	
}
