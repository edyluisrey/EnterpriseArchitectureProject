package edu.mum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.mum.domain.status.ReservationStatus;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "checkInDate")
	private Date checkInDate;
	
	@Column(name = "checkOutDate")
	private Date checkOutDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "reservationStatus")
	private ReservationStatus reservationStatus;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Room> rooms = new ArrayList<>();
}
