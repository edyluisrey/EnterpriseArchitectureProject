package edu.mum.rest.client.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.domain.Reservation;

@Component
public interface ReservationRestService {

	public List<Reservation>  findAll( ); 
	
	public Reservation getReservationById(Long id);
	
	public void save(Reservation reservation);
	
	public void updateReservation(Reservation reservation); 
	
	public void deleteReservation(Long id);

}
