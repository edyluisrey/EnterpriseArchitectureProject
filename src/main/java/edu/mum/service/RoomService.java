package edu.mum.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.domain.Room;

public interface RoomService {
	
	public void save(Room Room);
	@PreAuthorize("ROLE_ADMIN")
	public void update(Room Room);
	
	@PreAuthorize("ROLE_ADMIN")
	public void delete(Room Room);
	@Secured("ROLE_ADMIN")
	public void deleteById(Long RoomId);
	
	public Room findRoomById(Long RoomId);
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public List<Room> findAll();
	
}
