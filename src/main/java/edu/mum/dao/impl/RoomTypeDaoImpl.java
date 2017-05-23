package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.RoomTypeDao;
import edu.mum.domain.RoomType;

@Repository
public class RoomTypeDaoImpl extends GenericDaoImpl<RoomType> implements RoomTypeDao {

	public RoomTypeDaoImpl() {
		super.setDaoType(RoomType.class);
	}
	
}
