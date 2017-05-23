package edu.mum.service;

import java.util.List;

import edu.mum.domain.Room;

public interface RoomService {

	public void save(Room Room);
	
	public void update(Room Room);
	
	public void delete(Room Room);
	
	public void deleteById(Long RoomId);
	
	public Room findRoomById(Long RoomId);
	
	public List<Room> findAll();
	
}
