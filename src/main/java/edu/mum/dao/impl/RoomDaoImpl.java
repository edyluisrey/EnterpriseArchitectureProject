package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.RoomDao;
import edu.mum.domain.Room;

@Repository
public class RoomDaoImpl extends GenericDaoImpl<Room> implements RoomDao {

	public RoomDaoImpl() {
		super.setDaoType(Room.class);
	}
	
}
