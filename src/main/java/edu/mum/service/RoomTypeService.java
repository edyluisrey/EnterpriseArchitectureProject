package edu.mum.service;

import java.util.List;

import edu.mum.domain.RoomType;

public interface RoomTypeService {

	public void save(RoomType RoomType);
	
	public void update(RoomType RoomType);
	
	public void delete(RoomType RoomType);
	
	public void deleteById(Long RoomTypeId);
	
	public RoomType findRoomTypeById(Long RoomTypeId);
	
	public List<RoomType> findAll();
	
}
