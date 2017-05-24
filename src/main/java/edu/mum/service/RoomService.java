package edu.mum.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Room;

public interface RoomService {
	
	public void save(Room Room);
	
	public void update(Room Room);
	
	
	public void delete(Room Room);
	
	public void deleteById(Long RoomId);
	
	public Room findRoomById(Long RoomId);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Room> findAll();
	
}
