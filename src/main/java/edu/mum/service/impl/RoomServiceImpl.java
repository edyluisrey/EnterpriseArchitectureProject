package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Auditor;
import edu.mum.dao.RoomDao;
import edu.mum.domain.Room;
import edu.mum.service.RoomService;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao RoomDao;
	
	@Auditor
	@Override
	public void save(Room Room) {
		RoomDao.save(Room);
	}
    
	@Auditor
	@Override
	public void update(Room Room) {
		RoomDao.update(Room);
	}
	
	@Auditor
	@Override
	public void delete(Room Room) {
		RoomDao.delete(Room.getId());
	}

	@Override
	public void deleteById(Long RoomId) {
		RoomDao.delete(RoomId);
	}

	@Override
	public Room findRoomById(Long RoomId) {
		return RoomDao.findOne(RoomId);
	}

	@Override
	public List<Room> findAll() {
		return RoomDao.findAll();
	}

}
