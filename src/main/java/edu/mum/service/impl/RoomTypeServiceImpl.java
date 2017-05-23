package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.RoomTypeDao;
import edu.mum.domain.RoomType;
import edu.mum.service.RoomTypeService;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	private RoomTypeDao RoomTypeDao;
	
	@Override
	public void save(RoomType RoomType) {
		RoomTypeDao.save(RoomType);
	}

	@Override
	public void update(RoomType RoomType) {
		RoomTypeDao.update(RoomType);
	}

	@Override
	public void delete(RoomType RoomType) {
		RoomTypeDao.delete(RoomType.getId());
	}

	@Override
	public void deleteById(Long RoomTypeId) {
		RoomTypeDao.delete(RoomTypeId);
	}

	@Override
	public RoomType findRoomTypeById(Long RoomTypeId) {
		return RoomTypeDao.findOne(RoomTypeId);
	}

	@Override
	public List<RoomType> findAll() {
		return RoomTypeDao.findAll();
	}

}
