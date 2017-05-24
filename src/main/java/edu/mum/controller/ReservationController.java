package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Reservation;
import edu.mum.service.ReservationService;

@RestController
@RequestMapping({"/api/reservations"})
public class ReservationController {
	
	@Autowired
	private ReservationService  reservationService;

	@RequestMapping
	public @ResponseBody List<Reservation>  findAll( ) {
		return  reservationService.findAll();
 
	}
	
  	@RequestMapping("/{id}")
	public Reservation getReservationById(@PathVariable("id") Long id) {
		return   reservationService.findReservationById(id);
 
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewreservationToBeAddedForm(@RequestBody Reservation reservationToBeAdded) {
		reservationService.save(reservationToBeAdded);
 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateReservation(@RequestBody Reservation reservation) {
		reservationService.update(reservation);

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteReservation(@PathVariable("id") Long id) {
		reservationService.deleteById(id);

	}
	
 
}
