package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.GroupDao;
import edu.mum.domain.Group;
import edu.mum.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao GroupDao;
	
	@Override
	public void save(Group Group) {
		GroupDao.save(Group);
	}

	@Override
	public void update(Group Group) {
		GroupDao.update(Group);
	}

	@Override
	public void delete(Group Group) {
		GroupDao.delete(Group.getId());
	}

	@Override
	public void deleteById(Long GroupId) {
		GroupDao.delete(GroupId);
	}

	@Override
	public Group findGroupById(Long GroupId) {
		return GroupDao.findOne(GroupId);
	}

	@Override
	public List<Group> findAll() {
		return GroupDao.findAll();
	}

}
