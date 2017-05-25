package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Auditor;
import edu.mum.dao.RoomDao;
import edu.mum.domain.Room;
import edu.mum.service.RoomService;
import edu.mum.service.RoomTypeService;
import edu.mum.validation.ServiceValidation;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao RoomDao;
	
	@Auditor
	@Override
	@ServiceValidation
	public void save(Room room) {
		RoomDao.save(room);
	}
    
	@Auditor
	@Override
	@ServiceValidation
	public void update(Room room) {
		RoomDao.update(room);
	}
	
	@Auditor
	@Override
	public void delete(Room room) {
		RoomDao.delete(room.getId());
	}

	@Override
	public void deleteById(Long roomId) {
		RoomDao.delete(roomId);
	}

	@Override
	public Room findRoomById(Long roomId) {
		return RoomDao.findOne(roomId);
	}

	@Override
	public List<Room> findAll() {
		return RoomDao.findAll();
	}

}
