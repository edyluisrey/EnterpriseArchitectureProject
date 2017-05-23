package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.GroupDao;
import edu.mum.domain.Group;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao {

	public GroupDaoImpl() {
		super.setDaoType(Group.class);
	}

}