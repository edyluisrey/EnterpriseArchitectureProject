package edu.mum.service;

import java.util.List;

import edu.mum.domain.Reservation;

public interface ReservationService {

	public void save(Reservation Reservation);
	
	public void update(Reservation Reservation);
	
	public void delete(Reservation Reservation);
	
	public void deleteById(Long ReservationId);
	
	public Reservation findReservationById(Long ReservationId);
	
	public List<Reservation> findAll();
	
}
