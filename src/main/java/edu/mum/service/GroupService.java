package edu.mum.service;

import java.util.List;

import edu.mum.domain.Group;

public interface GroupService {

	public void save(Group Group);
	
	public void update(Group Group);
	
	public void delete(Group Group);
	
	public void deleteById(Long GroupId);
	
	public Group findGroupById(Long GroupId);
	
	public List<Group> findAll();
	
}
