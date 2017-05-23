package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ReservationDao;
import edu.mum.domain.Reservation;

@Repository
public class ReservationDaoImpl extends GenericDaoImpl<Reservation> implements ReservationDao {

	public ReservationDaoImpl() {
		super.setDaoType(Reservation.class);
	}
	
}
